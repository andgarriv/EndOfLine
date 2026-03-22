import subprocess

# Ejecutar mvn spring-boot:run en una nueva ventana de cmd
subprocess.Popen(
    ["cmd.exe", "/k", "mvn spring-boot:run"],
    creationflags=subprocess.CREATE_NEW_CONSOLE,
)

# Ejecutar npm start en una nueva ventana de cmd dentro de frontend
subprocess.Popen(
    ["cmd.exe", "/k", "npm start"],
    cwd="frontend",
    creationflags=subprocess.CREATE_NEW_CONSOLE,
)
