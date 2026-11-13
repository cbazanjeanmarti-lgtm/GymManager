import singleton.ConfiguracionGimnasio;
import factory.Usuario;
import factory.UsuarioFactory;
import builder.Rutina;
import composite.ComponenteEntrenamiento;
import composite.Ejercicio;
import composite.CircuitoEntrenamiento;
import decorator.Membresia;
import decorator.MembresiaBasica;
import decorator.AccesoSaunaDecorator;
import decorator.NutricionDecorator;
import decorator.CasilleroVipDecorator;
import adapter.ServicioPago;
import adapter.PasarelaExternaAPI;
import adapter.PasarelaAdapter;

public class MainGym {
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("          SISTEMA DE GESTIÓN DE GIMNASIO             ");
        System.out.println("======================================================\n");

        System.out.println("--- 1. SINGLETON (Configuración del Gimnasio) ---");
        ConfiguracionGimnasio config = ConfiguracionGimnasio.getInstancia();
        System.out.println("Gimnasio : " + config.getNombreGimnasio());
        System.out.println("Aforo    : " + config.getAforoMaximo() + " personas");
        System.out.println("Horario  : " + config.getHorarioAtencion());

        System.out.println("\n--- 2. FACTORY METHOD (Registro de Usuarios) ---");
        Usuario cliente = UsuarioFactory.crearUsuario(
                "CLIENTE", "C-101", "Marco Antonio", "marco@gym.pe", "Hipertrofia muscular"
        );
        Usuario coach = UsuarioFactory.crearUsuario(
                "ENTRENADOR", "E-201", "Roberto Gómez", "roberto.coach@gym.pe", "Fuerza y Acondicionamiento"
        );
        cliente.mostrarDetalle();
        coach.mostrarDetalle();

        System.out.println("\n--- 3. BUILDER (Diseño de Rutina de Entrenamiento) ---");
        Rutina rutinaTorso = new Rutina.Builder("Fuerza & Hipertrofia Torso")
                .conCalentamiento("10 min remo + rotadores con banda")
                .conBloquePrincipal("Press Banca Plano, Remo con Barra, Fondos en Paralelas")
                .conSeries(4)
                .conRepeticiones(8)
                .conDescanso(2)
                .build();
        System.out.println(rutinaTorso);

        System.out.println("\n--- 4. COMPOSITE (Estructura de Bloques y Ejercicios) ---");
        CircuitoEntrenamiento rutinaGeneral = new CircuitoEntrenamiento("Rutina Completa del Día");

        CircuitoEntrenamiento bloqueCalentamiento = new CircuitoEntrenamiento("Bloque de Activación");
        bloqueCalentamiento.agregar(new Ejercicio("Cuerda para saltar", 5, "Cardiovascular"));
        bloqueCalentamiento.agregar(new Ejercicio("Movilidad escapular", 5, "Hombro/Espalda"));

        CircuitoEntrenamiento bloqueFuerza = new CircuitoEntrenamiento("Bloque de Fuerza Principal");
        bloqueFuerza.agregar(new Ejercicio("Press Banca Plano", 15, "Pectoral"));
        bloqueFuerza.agregar(new Ejercicio("Remo con Barra T", 15, "Dorsal"));

        rutinaGeneral.agregar(bloqueCalentamiento);
        rutinaGeneral.agregar(bloqueFuerza);

        rutinaGeneral.ejecutar();
        System.out.println(">> Tiempo total acumulado: " + rutinaGeneral.getDuracionMinutos() + " minutos.");

        System.out.println("\n--- 5. DECORATOR (Personalización de Membresía) ---");
        Membresia miPlan = new MembresiaBasica();
        System.out.println("Plan inicial : " + miPlan.getDescripcion() + " -> S/ " + miPlan.getCosto());

        miPlan = new AccesoSaunaDecorator(miPlan);
        miPlan = new NutricionDecorator(miPlan);
        miPlan = new CasilleroVipDecorator(miPlan);

        System.out.println("Plan final   : " + miPlan.getDescripcion());
        System.out.println("Precio final : S/ " + miPlan.getCosto());

        System.out.println("\n--- 6. ADAPTER (Integración de Pasarela de Pagos Externa) ---");
        PasarelaExternaAPI apiExterna = new PasarelaExternaAPI();
        ServicioPago procesadorPago = new PasarelaAdapter(apiExterna);

        boolean exito = procesadorPago.procesarPago(cliente.getId(), miPlan.getCosto(), "PEN");
        System.out.println("Estado de suscripción: " + (exito ? "ACTIVA" : "PENDIENTE"));

        System.out.println("\n======================================================");
        System.out.println("       EJECUCIÓN COMPLETADA SATISFACTORIAMENTE        ");
        System.out.println("======================================================");
    }
}
