/**
 * Precompiled [spring-bootstrap-conventions.gradle.kts][Spring_bootstrap_conventions_gradle] script plugin.
 *
 * @see Spring_bootstrap_conventions_gradle
 */
public
class SpringBootstrapConventionsPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Spring_bootstrap_conventions_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
