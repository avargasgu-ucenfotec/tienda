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
- [ ] Se debe implementar el funcionamiento pleno de las clases **Cliente**, **ColaClientes**, **Tienda** y **ArbolProductos** así como la gestión de la compra de la **ListaProductos** que cada **Cliente** almacena.
- [ ] Los **Productos** que cada **Cliente** añade a su **ListaProductos** personal, llamada **carrito**, se debe elegir desde un **inventario** almacenado en la **Tienda**, el cual debe ser un objeto de la clase **ArbolProductos**, la cual se debe implementar como un árbol binario de búsqueda cuyo nodo es un **Producto**, cuyo **nombre** se puede utilizar como llave del árbol.
- [ ] La clase **ColaClientes** debe implementarse como una cola de prioridad, para lo cual cada **Cliente** debe tener un atributo **prioridad** que indica, mediante un número entero entre el **1** y el **3**, el grado de prioridad asignado a su atención: **1** para **Clientes** básicos, **2** para **Clientes** afiliados a la **Tienda** y **3** para **Clientes** premium. A la hora de procesar la atención de un **Cliente**, quien debe ser atendido es el **Cliente** que tenga una **prioridad** más alta de los que actualmente están en la cola.
- [ ] La **Tienda** debe tener un atributo que se un objeto de la clase **ColaClientes**.
- [ ] Además de todas las clases de entidad requeridas para la implementación de la aplicación, de acuerdo con el alcance indicado hasta este punto, cada grupo debe desarrollar un **menu()** de consola dentro de una clase funcional que permita interactuar con el programa de forma intuitiva y amigable con el usuario.
- [ ] El **menu()** debe permitir la inserción de **Productos** al **inventario** de la **Tienda**.
- [ ] El **menu()** debe permitir la inserción de **Clientes** en la **ColaClientes** (la cual implica el llenado de su **carrito** a partir de lo que hay disponible en el **inventario**).
- [ ] El **menu()** debe permitir la atención del siguiente **Cliente** (lo cual implica la impresión de un reporte que represente la factura asociada con su **carrito**, incluyendo su costo total acumulado).
- [ ] El **menu()** se debe alojar dentro de la clase **Main** del programa, donde también debe estar la rutina **main()** que lo invoque y lo haga funcionar correctamente.
