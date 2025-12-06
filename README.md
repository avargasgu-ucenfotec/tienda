# Aplicación de gestión de inventarios

El presente trabajo consiste en el desarrollo de una aplicación para la gestión de un sistema de ventas de productos en línea. Para satisfacer dicha finalidad, el sistema por desarrollar debe implementar y utilizar estructuras de datos dinámicas para el control del inventario de productos y de los pedidos realizados.

## Primer avance
### Requerimientos
- [x] La aplicación de gestión del sistema de ventas de productos debe permitir la inserción de **Productos** a una **ListaProductos**, la cual se debe implementar como una lista enlazada simple.
- [x] De cada **Producto** hace falta registrar su **nombre**, **precio**, **categoria** y **fechaVencimiento** (si aplica), además de una **cantidad**, la cual representará la cantidad de unidades del **Producto** que se agregarán al **carrito** del **Cliente** y la cantidad de unidades del **Producto** que la **Tienda** tiene en **inventario**.
- [x] Cada **Producto** debe además contener una **listaImagenes**, la cual se puede implementar mediante un objeto de la clase **ArrayList** que almacene **Strings** con las rutas de las imágenes, las cuales deben ubicarse dentro de un directorio que forme parte del proyecto de Java.
- [x] La estructura de datos debe tener implementados todos los métodos habituales asociados con una lista enlazada simple, permitiendo la inserción tanto al inicio como al final de la lista, la modificación de los **Productos** (incluyendo la añadidura de imágenes a su lista), y tener además un método adicional que permita recorrer la **ListaProductos** e imprimir un reporte de los costos totales correspondiente a cada **Producto** que incluye en función de su cantidad, así como el costo total acumulado de la lista completa.
- [x] Además de las dos clases de entidad requeridas para la implementación de la **ListaProductos** como tal (i.e., la clase nodo y la clase estructura), cada grupo debe desarrollar un **menu()** de consola dentro de una clase funcional que permita interactuar con la lista de forma intuitiva y amigable con el usuario.
- [x] El menú se debe alojar dentro de la clase **Main** del programa, donde también debe estar la rutina **main()** que lo invoque y lo haga funcionar correctamente.

## Segundo avance
### Requerimientos
- [x] Se debe implementar el funcionamiento pleno de las clases **Cliente**, **ColaClientes**, **Tienda** y **ArbolProductos** así como la gestión de la compra de la **ListaProductos** que cada **Cliente** almacena.
- [x] Los **Productos** que cada **Cliente** añade a su **ListaProductos** personal, llamada **carrito**, se debe elegir desde un **inventario** almacenado en la **Tienda**, el cual debe ser un objeto de la clase **ArbolProductos**, la cual se debe implementar como un árbol binario de búsqueda cuyo nodo es un **Producto**, cuyo **nombre** se puede utilizar como llave del árbol.
- [x] La clase **ColaClientes** debe implementarse como una cola de prioridad, para lo cual cada **Cliente** debe tener un atributo **prioridad** que indica, mediante un número entero entre el **1** y el **3**, el grado de prioridad asignado a su atención: **1** para **Clientes** básicos, **2** para **Clientes** afiliados a la **Tienda** y **3** para **Clientes** premium. A la hora de procesar la atención de un **Cliente**, quien debe ser atendido es el **Cliente** que tenga una **prioridad** más alta de los que actualmente están en la cola.
- [x] La **Tienda** debe tener un atributo que se un objeto de la clase **ColaClientes**.
- [x] Además de todas las clases de entidad requeridas para la implementación de la aplicación, de acuerdo con el alcance indicado hasta este punto, cada grupo debe desarrollar un **menu()** de consola dentro de una clase funcional que permita interactuar con el programa de forma intuitiva y amigable con el usuario.
- [x] El **menu()** debe permitir la inserción de **Productos** al **inventario** de la **Tienda**.
- [x] El **menu()** debe permitir la inserción de **Clientes** en la **ColaClientes** (la cual implica el llenado de su **carrito** a partir de lo que hay disponible en el **inventario**).
- [x] El **menu()** debe permitir la atención del siguiente **Cliente** (lo cual implica la impresión de un reporte que represente la factura asociada con su **carrito**, incluyendo su costo total acumulado).
- [x] El **menu()** se debe alojar dentro de la clase **Main** del programa, donde también debe estar la rutina **main()** que lo invoque y lo haga funcionar correctamente.

## Avance final
### Requerimientos
- [ ] Agregar un **Grafo** ponderado y no dirigido que almacene una serie de **ubicaciones** haciendo el papel de vértices y los **pesos** de las aristas que las unen (que corresponden a la distancia que hay entre las ubicaciones).
- [ ] Tanto la **Tienda** como los **Clientes** deben tener una **ubicación**, de modo que cuando el siguiente **Cliente** en ser atendido sea atendido, junto con el reporte de su factura que se debe imprimir en pantalla se indique también el camino más corto entre su **ubicación** y la de la **Tienda**, determinado mediante el algoritmo de búsqueda de caminos de Dijkstra, así como la distancia asociada con dicho camino.
- [ ] Como parte de la gestión necesaria del **Grafo** debe ser posible desde el **menu()** del programa la inserción de nuevos vértices y aristas.
- [ ] Se debe tener una lógica de verificación, a la hora de atender al siguiente **Cliente** de la cola, de modo que dicha operación no sea posible si la **ubicación** del **Cliente** (la cuál se debe agregar como vértice al **Grafo** de forma automática cuando éste es insertado en la **ColaClientes**) está desconectada del resto de la estructura.

## Casos de prueba
### Flujo 1. Insertar un producto a un inventario vacío, insertar un cliente a la cola y concretar la compra asociada al único cliente en la cola
#### Paso 1. Visualizar del estado inicial del sistema
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado inicial de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| N/A                                      | 0.0        | 0        | 0.0        |
+------------------------------------------+------------+----------+------------+

Clientes en espera: []
Siguiente cliente a ser atendido: No hay clientes en la cola.
```
Se confirma que el inventario está vacío y no hay clientes en la cola de espera.

#### Paso 2. Inserción de un producto al inventario de la tienda
El usuario selecciona la opción 1 del menú con el fin de ingresar los datos asociados al producto que desea insertar al inventario.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 1
```
```
Ingrese el título del álbum: Thriller
Ingrese el precio unitario del álbum: 19635.0
Ingrese el género musical del álbum: Pop
Ingrese la fecha de lanzamiento del álbum: 1982
Ingrese la cantidad de unidades del álbum: 15
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Thriller                                 | 19635.0    | 15       | 294525.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: []
Siguiente cliente a ser atendido: No hay clientes en la cola.
```
Se confirma que el inventario muestra el nombre producto, acompañado de su precio unitario, su cantidad disponible y el monto total asociado a dicha cantidad de productos.

#### Paso 3. Inserción de un cliente en la cola
El usuario selecciona la opción 2 del menú con el fin de ingresar los datos asociados al cliente, así como el producto que se desea comprar.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 2
```
```
Ingrese el nombre del cliente: Roberto Vargas
Ingrese el número de cédula del cliente: 113090279
Ingrese la prioridad del cliente [1/2/3]: 1
Ingrese el nombre de álbum que desea agregar al carrito: Thriller
Ingrese la cantidad de álbumes que desea adquirir: 2
¿Desea agregar otro producto a su carrito de compras? [si/no] no
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Thriller                                 | 19635.0    | 13       | 255255.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 1]
Siguiente cliente a ser atendido: Roberto Vargas
```
Se confirma que el inventario muestra el nombre producto, acompañado de su precio unitario, su cantidad disponible actualizada y el monto total actualizado asociado a dicha cantidad de productos.
Además se muestra que hay un cliente en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad.

#### Paso 4. Atención del cliente en la cola
El usuario selecciona la opción 3 del menú con el fin de concretar la compra y desplegar la factura correspondiente.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 3
```
```
Atendiendo al cliente: Roberto Vargas
+------------------------------------------+------------+----------+------------+
| Factura                                  |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Thriller                                 | 19635.0    | 2        | 39270.0    |
+------------------------------------------+------------+----------+------------+
|                                          |            |          | 39270.0    |
+------------------------------------------+------------+----------+------------+
```
Se confirma que la factura muestra el nombre producto, acompañado de su precio unitario, y el monto total de la compra.

El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Thriller                                 | 19635.0    | 13       | 255255.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: []
Siguiente cliente a ser atendido: No hay clientes en la cola.
```
Se confirma que el inventario muestra el nombre del producto, acompañado de su precio unitario, su cantidad disponible actualizada y el monto total actualizado asociado a dicha cantidad de productos.
Además se muestra que no hay clientes en la cola.

#### Paso 5. Cerrar el programa
El usuario selecciona la opción 0 del menú con el fin de cerrar el programa.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 0
```
```
Cerrando el programa...
```

### Flujo 2. Insertar un producto a un inventario que ya tiene 5 productos, insertar 4 clientes de distintas prioridades a la cola y concretar la compra de múltiples productos del cliente de mayor prioridad
#### Paso 1. Visualizar del estado inicial del sistema
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado inicial de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 35       | 105024.5   |
| Nevermind                                | 7052.5     | 20       | 141050.0   |
| The Number of the Beast                  | 5500.9     | 5        | 27504.5    |
| Thriller                                 | 19635.0    | 15       | 294525.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 10       | 100771.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: []
Siguiente cliente a ser atendido: No hay clientes en la cola.
```
Se confirma que el inventario no está vacío y no hay clientes en la cola de espera.

#### Paso 2. Inserción de un producto al inventario de la tienda
El usuario selecciona la opción 1 del menú con el fin de ingresar los datos asociados al producto que desea insertar al inventario.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 1
```
```
Seleccione una opción del menú: 1
Ingrese el título del álbum: Texas Flood
Ingrese el precio unitario del álbum: 5791.6
Ingrese el género musical del álbum: Blues
Ingrese la fecha de lanzamiento del álbum: 1983
Ingrese la cantidad de unidades del álbum: 10
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 35       | 105024.5   |
| Nevermind                                | 7052.5     | 20       | 141050.0   |
| Texas Flood                              | 5791.6     | 10       | 57916.0    |
| The Number of the Beast                  | 5500.9     | 5        | 27504.5    |
| Thriller                                 | 19635.0    | 15       | 294525.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 10       | 100771.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: []
Siguiente cliente a ser atendido: No hay clientes en la cola.
```
Se confirma que el inventario muestra el nombre del producto insertado, acompañado de su precio unitario, su cantidad disponible y el monto total asociado a dicha cantidad de productos.

#### Paso 3. Inserción de 4 clientes en la cola
El usuario selecciona la opción 2 del menú con el fin de ingresar los datos asociados al primer cliente, así como el producto que se desea comprar.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 2
```
```
Ingrese el nombre del cliente: Roberto Vargas
Ingrese el número de cédula del cliente: 113090279
Ingrese la prioridad del cliente [1/2/3]: 2
Ingrese el nombre de álbum que desea agregar al carrito: The Number of the Beast
Ingrese la cantidad de álbumes que desea adquirir: 1
¿Desea agregar otro producto a su carrito de compras? [si/no] no
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 35       | 105024.5   |
| Nevermind                                | 7052.5     | 20       | 141050.0   |
| Texas Flood                              | 5791.6     | 10       | 57916.0    |
| The Number of the Beast                  | 5500.9     | 4        | 22003.6    |
| Thriller                                 | 19635.0    | 15       | 294525.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 10       | 100771.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 2]
Siguiente cliente a ser atendido: Roberto Vargas
```
Se confirma que el inventario actualiza las cantidades disponibles y el monto total.
Además se muestra que hay un cliente en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad.

El usuario selecciona la opción 2 del menú con el fin de ingresar los datos asociados al segundo cliente, así como el producto que se desea comprar.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 2
```
```
Ingrese el nombre del cliente: Laura Retana
Ingrese el número de cédula del cliente: 214100380
Ingrese la prioridad del cliente [1/2/3]: 3
Ingrese el nombre de álbum que desea agregar al carrito: Thriller
Ingrese la cantidad de álbumes que desea adquirir: 2
¿Desea agregar otro producto a su carrito de compras? [si/no] si
Ingrese el nombre de álbum que desea agregar al carrito: Nevermind
Ingrese la cantidad de álbumes que desea adquirir: 1
¿Desea agregar otro producto a su carrito de compras? [si/no] no
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 35       | 105024.5   |
| Nevermind                                | 7052.5     | 19       | 133997.5   |
| Texas Flood                              | 5791.6     | 10       | 57916.0    |
| The Number of the Beast                  | 5500.9     | 4        | 22003.6    |
| Thriller                                 | 19635.0    | 13       | 255255.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 10       | 100771.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 2, 
Nombre completo: Laura Retana, Número de cédula: 214100380, Prioridad: 3]
Siguiente cliente a ser atendido: Roberto Vargas
```
Se confirma que el inventario actualiza las cantidades disponibles y el monto total.
Además se muestra que hay dos clientes en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad, no cambia.

El usuario selecciona la opción 2 del menú con el fin de ingresar los datos asociados al tercer cliente, así como el producto que se desea comprar.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 2
```
```
Ingrese el nombre del cliente: Patricia Guevara
Ingrese el número de cédula del cliente: 325211491
Ingrese la prioridad del cliente [1/2/3]: 1
Ingrese el nombre de álbum que desea agregar al carrito: Kind of Blue
Ingrese la cantidad de álbumes que desea adquirir: 3
¿Desea agregar otro producto a su carrito de compras? [si/no] si
Ingrese el nombre de álbum que desea agregar al carrito: Texas Flood
Ingrese la cantidad de álbumes que desea adquirir: 1
¿Desea agregar otro producto a su carrito de compras? [si/no] no
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 32       | 96022.4    |
| Nevermind                                | 7052.5     | 19       | 133997.5   |
| Texas Flood                              | 5791.6     | 10       | 57916.0    |
| The Number of the Beast                  | 5500.9     | 4        | 22003.6    |
| Thriller                                 | 19635.0    | 13       | 255255.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 10       | 100771.0   |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Patricia Guevara, Número de cédula: 325211491, Prioridad: 1, 
Nombre completo: Laura Retana, Número de cédula: 214100380, Prioridad: 3, 
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 2]
Siguiente cliente a ser atendido: Patricia Guevara
```
Se confirma que el inventario actualiza las cantidades disponibles y el monto total.
Además se muestra que hay tres clientes en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad, ha cambiado.

El usuario selecciona la opción 2 del menú con el fin de ingresar los datos asociados al cuarto cliente, así como el producto que se desea comprar.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 2
```
```
Ingrese el nombre del cliente: Jorge Castillo
Ingrese el número de cédula del cliente: 436322510
Ingrese la prioridad del cliente [1/2/3]: 1
Ingrese el nombre de álbum que desea agregar al carrito: Sgt. Pepper's Lonely Hearts Club Band
Ingrese la cantidad de álbumes que desea adquirir: 2
¿Desea agregar otro producto a su carrito de compras? [si/no] si
Ingrese el nombre de álbum que desea agregar al carrito: The Number of the Beast
Ingrese la cantidad de álbumes que desea adquirir: 2
¿Desea agregar otro producto a su carrito de compras? [si/no] no
```
El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 32       | 96022.4    |
| Nevermind                                | 7052.5     | 19       | 133997.5   |
| Texas Flood                              | 5791.6     | 9        | 52124.4    |
| The Number of the Beast                  | 5500.9     | 2        | 11001.8    |
| Thriller                                 | 19635.0    | 13       | 255255.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 8        | 80616.8    |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Patricia Guevara, Número de cédula: 325211491, Prioridad: 1, 
Nombre completo: Jorge Castillo, Número de cédula: 436322510, Prioridad: 1, 
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 2, 
Nombre completo: Laura Retana, Número de cédula: 214100380, Prioridad: 3]
Siguiente cliente a ser atendido: Patricia Guevara
```
Se confirma que el inventario actualiza las cantidades disponibles y el monto total.
Además se muestra que hay cuatro clientes en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad, no ha cambiado.

#### Paso 4. Atención del cliente en la cola
El usuario selecciona la opción 3 del menú con el fin de concretar la compra y desplegar la factura correspondiente.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 3
```
```
Atendiendo al cliente: Patricia Guevara
+------------------------------------------+------------+----------+------------+
| Factura                                  |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Texas Flood                              | 5791.6     | 1        | 5791.6     |
| Kind of Blue                             | 3000.7     | 3        | 9002.1     |
+------------------------------------------+------------+----------+------------+
|                                          |            |          | 14793.7    |
+------------------------------------------+------------+----------+------------+
```
Se confirma que la factura muestra el nombre producto, acompañado de su precio unitario, y el monto total de la compra.

El usuario selecciona la opción 4 del menú con el fin de visualizar el estado actual de la tienda.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 4
```
```
+------------------------------------------+------------+----------+------------+
| Inventario                               |            |          |            |
+------------------------------------------+------------+----------+------------+
| Título                                   | Precio     | Cantidad | Total      |
+------------------------------------------+------------+----------+------------+
| Kind of Blue                             | 3000.7     | 32       | 96022.4    |
| Nevermind                                | 7052.5     | 19       | 133997.5   |
| Texas Flood                              | 5791.6     | 9        | 52124.4    |
| The Number of the Beast                  | 5500.9     | 2        | 11001.8    |
| Thriller                                 | 19635.0    | 13       | 255255.0   |
| Sgt. Pepper's Lonely Hearts Club Band    | 10077.1    | 8        | 80616.8    |
+------------------------------------------+------------+----------+------------+

Clientes en espera: [
Nombre completo: Jorge Castillo, Número de cédula: 436322510, Prioridad: 1, 
Nombre completo: Laura Retana, Número de cédula: 214100380, Prioridad: 3, 
Nombre completo: Roberto Vargas, Número de cédula: 113090279, Prioridad: 2]
Siguiente cliente a ser atendido: Jorge Castillo
```
Se confirma que el inventario actualizado muestra el nombre de los productos, acompañados de sus precios unitarios, sus cantidades disponibles y el monto total actualizado asociado a dicha cantidad de productos.
Además se muestra que hay tres clientes en la cola, y el siguiente cliente que debe ser atendido, basado en la prioridad, se ha actualizado.

#### Paso 5. Cerrar el programa
El usuario selecciona la opción 0 del menú con el fin de cerrar el programa.
```
 --- Menú principal ---
[ 1] Insertar producto al inventario
[ 2] Insertar cliente a la cola
[ 3] Atender cliente
[ 4] Imprimir estado de la tienda
[ 0] Salir

Seleccione una opción del menú: 0
```
```
Cerrando el programa...
```
