#  Aplicación CLI de Tareas

Esta es una aplicación de **interfaz de línea de comandos (CLI)** simple para **gestionar tareas**.
Permite agregar, actualizar, eliminar, marcar y listar tareas directamente desde la terminal.


## Funcionalidades

* **Agregar una tarea:** Añade una nueva tarea con una descripción.
* **Actualizar una tarea:** Modifica la descripción de una tarea existente.
* **Eliminar una tarea:** Elimina una tarea por su ID.
* **Marcar una tarea:** Marca una tarea como “en progreso” o “hecha”.
* **Listar tareas:** Muestra todas las tareas o las filtra por estado (`todo`, `in-progress`, `done`).


## Instalación y ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/DiegoBauti/TaskTrackerCLI.git
   cd task_tracker_cli

2. **Ejecuta la aplicación:**
   Los archivos compilados se encuentran en la carpeta `out`.
   Desde la terminal, ejecuta la aplicación con el siguiente formato:

   ```bash
   java TaskCLIApp <comando> [argumentos]
   ```


## Ejemplos de uso

```bash
# Agregar una nueva tarea
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Actualizar y eliminar tareas
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1

# Marcar una tarea como en progreso o completada
task-cli mark-in-progress 1
task-cli mark-done 1

# Listar todas las tareas
task-cli list

# Listar las tareas por estado
task-cli list done
task-cli list todo
task-cli list in-progress

```


