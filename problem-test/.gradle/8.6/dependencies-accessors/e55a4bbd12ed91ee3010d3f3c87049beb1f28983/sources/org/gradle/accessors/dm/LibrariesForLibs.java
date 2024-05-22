package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final DbLibraryAccessors laccForDbLibraryAccessors = new DbLibraryAccessors(owner);
    private final FlywayLibraryAccessors laccForFlywayLibraryAccessors = new FlywayLibraryAccessors(owner);
    private final JacksonLibraryAccessors laccForJacksonLibraryAccessors = new JacksonLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final JjwtLibraryAccessors laccForJjwtLibraryAccessors = new JjwtLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final KotestLibraryAccessors laccForKotestLibraryAccessors = new KotestLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final LoggingLibraryAccessors laccForLoggingLibraryAccessors = new LoggingLibraryAccessors(owner);
    private final MapstructLibraryAccessors laccForMapstructLibraryAccessors = new MapstructLibraryAccessors(owner);
    private final MockLibraryAccessors laccForMockLibraryAccessors = new MockLibraryAccessors(owner);
    private final ReactorLibraryAccessors laccForReactorLibraryAccessors = new ReactorLibraryAccessors(owner);
    private final SpringLibraryAccessors laccForSpringLibraryAccessors = new SpringLibraryAccessors(owner);
    private final SpringdocLibraryAccessors laccForSpringdocLibraryAccessors = new SpringdocLibraryAccessors(owner);
    private final TestcontainersLibraryAccessors laccForTestcontainersLibraryAccessors = new TestcontainersLibraryAccessors(owner);
    private final TikaLibraryAccessors laccForTikaLibraryAccessors = new TikaLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>hamcrest</b> with <b>org.hamcrest:hamcrest</b> coordinates and
     * with version reference <b>hamcrest</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getHamcrest() {
        return create("hamcrest");
    }

    /**
     * Dependency provider for <b>mockk</b> with <b>io.mockk:mockk</b> coordinates and
     * with version reference <b>mockk</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMockk() {
        return create("mockk");
    }

    /**
     * Dependency provider for <b>springmockk</b> with <b>com.ninja-squad:springmockk</b> coordinates and
     * with version reference <b>springmockk</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getSpringmockk() {
        return create("springmockk");
    }

    /**
     * Group of libraries at <b>commons</b>
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>db</b>
     */
    public DbLibraryAccessors getDb() {
        return laccForDbLibraryAccessors;
    }

    /**
     * Group of libraries at <b>flyway</b>
     */
    public FlywayLibraryAccessors getFlyway() {
        return laccForFlywayLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jackson</b>
     */
    public JacksonLibraryAccessors getJackson() {
        return laccForJacksonLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jakarta</b>
     */
    public JakartaLibraryAccessors getJakarta() {
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jjwt</b>
     */
    public JjwtLibraryAccessors getJjwt() {
        return laccForJjwtLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotest</b>
     */
    public KotestLibraryAccessors getKotest() {
        return laccForKotestLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlin</b>
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlinx</b>
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>ktor</b>
     */
    public KtorLibraryAccessors getKtor() {
        return laccForKtorLibraryAccessors;
    }

    /**
     * Group of libraries at <b>logging</b>
     */
    public LoggingLibraryAccessors getLogging() {
        return laccForLoggingLibraryAccessors;
    }

    /**
     * Group of libraries at <b>mapstruct</b>
     */
    public MapstructLibraryAccessors getMapstruct() {
        return laccForMapstructLibraryAccessors;
    }

    /**
     * Group of libraries at <b>mock</b>
     */
    public MockLibraryAccessors getMock() {
        return laccForMockLibraryAccessors;
    }

    /**
     * Group of libraries at <b>reactor</b>
     */
    public ReactorLibraryAccessors getReactor() {
        return laccForReactorLibraryAccessors;
    }

    /**
     * Group of libraries at <b>spring</b>
     */
    public SpringLibraryAccessors getSpring() {
        return laccForSpringLibraryAccessors;
    }

    /**
     * Group of libraries at <b>springdoc</b>
     */
    public SpringdocLibraryAccessors getSpringdoc() {
        return laccForSpringdocLibraryAccessors;
    }

    /**
     * Group of libraries at <b>testcontainers</b>
     */
    public TestcontainersLibraryAccessors getTestcontainers() {
        return laccForTestcontainersLibraryAccessors;
    }

    /**
     * Group of libraries at <b>tika</b>
     */
    public TikaLibraryAccessors getTika() {
        return laccForTikaLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>codec</b> with <b>commons-codec:commons-codec</b> coordinates and
         * with version reference <b>commons.codec</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCodec() {
            return create("commons.codec");
        }

    }

    public static class DbLibraryAccessors extends SubDependencyFactory {
        private final DbH2LibraryAccessors laccForDbH2LibraryAccessors = new DbH2LibraryAccessors(owner);
        private final DbMysqlLibraryAccessors laccForDbMysqlLibraryAccessors = new DbMysqlLibraryAccessors(owner);

        public DbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>db.h2</b>
         */
        public DbH2LibraryAccessors getH2() {
            return laccForDbH2LibraryAccessors;
        }

        /**
         * Group of libraries at <b>db.mysql</b>
         */
        public DbMysqlLibraryAccessors getMysql() {
            return laccForDbMysqlLibraryAccessors;
        }

    }

    public static class DbH2LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public DbH2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>h2</b> with <b>com.h2database:h2</b> coordinates and
         * with version reference <b>h2</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("db.h2");
        }

        /**
         * Dependency provider for <b>r2dbc</b> with <b>io.r2dbc:r2dbc-h2</b> coordinates and
         * with version reference <b>h2.r2dbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getR2dbc() {
            return create("db.h2.r2dbc");
        }

    }

    public static class DbMysqlLibraryAccessors extends SubDependencyFactory {

        public DbMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpa</b> with <b>com.mysql:mysql-connector-j</b> coordinates and
         * with version reference <b>mysql.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpa() {
            return create("db.mysql.jpa");
        }

        /**
         * Dependency provider for <b>r2dbc</b> with <b>io.asyncer:r2dbc-mysql</b> coordinates and
         * with version reference <b>mysql.r2dbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getR2dbc() {
            return create("db.mysql.r2dbc");
        }

    }

    public static class FlywayLibraryAccessors extends SubDependencyFactory {

        public FlywayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.flywaydb:flyway-core</b> coordinates and
         * with version reference <b>flyway</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("flyway.core");
        }

        /**
         * Dependency provider for <b>mysql</b> with <b>org.flywaydb:flyway-mysql</b> coordinates and
         * with version reference <b>flyway</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMysql() {
            return create("flyway.mysql");
        }

    }

    public static class JacksonLibraryAccessors extends SubDependencyFactory {
        private final JacksonDatatypeLibraryAccessors laccForJacksonDatatypeLibraryAccessors = new JacksonDatatypeLibraryAccessors(owner);
        private final JacksonModuleLibraryAccessors laccForJacksonModuleLibraryAccessors = new JacksonModuleLibraryAccessors(owner);

        public JacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>com.fasterxml.jackson.core:jackson-annotations</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("jackson.annotations");
        }

        /**
         * Dependency provider for <b>core</b> with <b>com.fasterxml.jackson.core:jackson-core</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("jackson.core");
        }

        /**
         * Dependency provider for <b>databind</b> with <b>com.fasterxml.jackson.core:jackson-databind</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatabind() {
            return create("jackson.databind");
        }

        /**
         * Group of libraries at <b>jackson.datatype</b>
         */
        public JacksonDatatypeLibraryAccessors getDatatype() {
            return laccForJacksonDatatypeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jackson.module</b>
         */
        public JacksonModuleLibraryAccessors getModule() {
            return laccForJacksonModuleLibraryAccessors;
        }

    }

    public static class JacksonDatatypeLibraryAccessors extends SubDependencyFactory {

        public JacksonDatatypeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdk8</b> with <b>com.fasterxml.jackson.datatype:jackson-datatype-jdk8</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJdk8() {
            return create("jackson.datatype.jdk8");
        }

        /**
         * Dependency provider for <b>jsr310</b> with <b>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsr310() {
            return create("jackson.datatype.jsr310");
        }

    }

    public static class JacksonModuleLibraryAccessors extends SubDependencyFactory {

        public JacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlin</b> with <b>com.fasterxml.jackson.module:jackson-module-kotlin</b> coordinates and
         * with version reference <b>jackson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKotlin() {
            return create("jackson.module.kotlin");
        }

    }

    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletLibraryAccessors laccForJakartaServletLibraryAccessors = new JakartaServletLibraryAccessors(owner);
        private final JakartaValidationLibraryAccessors laccForJakartaValidationLibraryAccessors = new JakartaValidationLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet</b>
         */
        public JakartaServletLibraryAccessors getServlet() {
            return laccForJakartaServletLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.validation</b>
         */
        public JakartaValidationLibraryAccessors getValidation() {
            return laccForJakartaValidationLibraryAccessors;
        }

    }

    public static class JakartaServletLibraryAccessors extends SubDependencyFactory {

        public JakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.servlet:jakarta.servlet-api</b> coordinates and
         * with version reference <b>jakarta.servlet.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jakarta.servlet.api");
        }

    }

    public static class JakartaValidationLibraryAccessors extends SubDependencyFactory {

        public JakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.validation:jakarta.validation-api</b> coordinates and
         * with version reference <b>jakarta.validation.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jakarta.validation.api");
        }

    }

    public static class JjwtLibraryAccessors extends SubDependencyFactory {

        public JjwtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>io.jsonwebtoken:jjwt-api</b> coordinates and
         * with version reference <b>jjwt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jjwt.api");
        }

        /**
         * Dependency provider for <b>impl</b> with <b>io.jsonwebtoken:jjwt-impl</b> coordinates and
         * with version reference <b>jjwt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getImpl() {
            return create("jjwt.impl");
        }

        /**
         * Dependency provider for <b>jackson</b> with <b>io.jsonwebtoken:jjwt-jackson</b> coordinates and
         * with version reference <b>jjwt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJackson() {
            return create("jjwt.jackson");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>org.junit.jupiter:junit-jupiter-api</b> coordinates and
         * with version reference <b>junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("junit");
        }

        /**
         * Dependency provider for <b>jupiter</b> with <b>org.junit.jupiter:junit-jupiter-api</b> coordinates and
         * with version reference <b>junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJupiter() {
            return create("junit.jupiter");
        }

    }

    public static class KotestLibraryAccessors extends SubDependencyFactory {
        private final KotestExtensionsLibraryAccessors laccForKotestExtensionsLibraryAccessors = new KotestExtensionsLibraryAccessors(owner);
        private final KotestRunnerLibraryAccessors laccForKotestRunnerLibraryAccessors = new KotestRunnerLibraryAccessors(owner);

        public KotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>kotest.extensions</b>
         */
        public KotestExtensionsLibraryAccessors getExtensions() {
            return laccForKotestExtensionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotest.runner</b>
         */
        public KotestRunnerLibraryAccessors getRunner() {
            return laccForKotestRunnerLibraryAccessors;
        }

    }

    public static class KotestExtensionsLibraryAccessors extends SubDependencyFactory {
        private final KotestExtensionsMockLibraryAccessors laccForKotestExtensionsMockLibraryAccessors = new KotestExtensionsMockLibraryAccessors(owner);

        public KotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>spring</b> with <b>io.kotest.extensions:kotest-extensions-spring</b> coordinates and
         * with version reference <b>kotest.extensions.spring</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpring() {
            return create("kotest.extensions.spring");
        }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>io.kotest.extensions:kotest-extensions-testcontainers</b> coordinates and
         * with version reference <b>kotest.extensions.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTestcontainers() {
            return create("kotest.extensions.testcontainers");
        }

        /**
         * Group of libraries at <b>kotest.extensions.mock</b>
         */
        public KotestExtensionsMockLibraryAccessors getMock() {
            return laccForKotestExtensionsMockLibraryAccessors;
        }

    }

    public static class KotestExtensionsMockLibraryAccessors extends SubDependencyFactory {

        public KotestExtensionsMockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>server</b> with <b>io.kotest.extensions:kotest-extensions-mockserver</b> coordinates and
         * with version reference <b>kotest.extensions.mock.server</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServer() {
            return create("kotest.extensions.mock.server");
        }

    }

    public static class KotestRunnerLibraryAccessors extends SubDependencyFactory {

        public KotestRunnerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit5</b> with <b>io.kotest:kotest-runner-junit5</b> coordinates and
         * with version reference <b>kotest.runner.junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit5() {
            return create("kotest.runner.junit5");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);
        private final KotlinKaptLibraryAccessors laccForKotlinKaptLibraryAccessors = new KotlinKaptLibraryAccessors(owner);
        private final KotlinSerializationLibraryAccessors laccForKotlinSerializationLibraryAccessors = new KotlinSerializationLibraryAccessors(owner);
        private final KotlinStdlibLibraryAccessors laccForKotlinStdlibLibraryAccessors = new KotlinStdlibLibraryAccessors(owner);
        private final KotlinTestLibraryAccessors laccForKotlinTestLibraryAccessors = new KotlinTestLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>allopen</b> with <b>org.jetbrains.kotlin:kotlin-allopen</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAllopen() {
            return create("kotlin.allopen");
        }

        /**
         * Dependency provider for <b>logging</b> with <b>io.github.oshai:kotlin-logging</b> coordinates and
         * with version reference <b>kotlin.logging</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogging() {
            return create("kotlin.logging");
        }

        /**
         * Dependency provider for <b>noarg</b> with <b>org.jetbrains.kotlin:kotlin-noarg</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNoarg() {
            return create("kotlin.noarg");
        }

        /**
         * Dependency provider for <b>reflect</b> with <b>org.jetbrains.kotlin:kotlin-reflect</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getReflect() {
            return create("kotlin.reflect");
        }

        /**
         * Group of libraries at <b>kotlin.gradle</b>
         */
        public KotlinGradleLibraryAccessors getGradle() {
            return laccForKotlinGradleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.kapt</b>
         */
        public KotlinKaptLibraryAccessors getKapt() {
            return laccForKotlinKaptLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.serialization</b>
         */
        public KotlinSerializationLibraryAccessors getSerialization() {
            return laccForKotlinSerializationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.stdlib</b>
         */
        public KotlinStdlibLibraryAccessors getStdlib() {
            return laccForKotlinStdlibLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.test</b>
         */
        public KotlinTestLibraryAccessors getTest() {
            return laccForKotlinTestLibraryAccessors;
        }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.jetbrains.kotlin:kotlin-gradle-plugin</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("kotlin.gradle.plugin");
        }

    }

    public static class KotlinKaptLibraryAccessors extends SubDependencyFactory {
        private final KotlinKaptGradleLibraryAccessors laccForKotlinKaptGradleLibraryAccessors = new KotlinKaptGradleLibraryAccessors(owner);

        public KotlinKaptLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>kotlin.kapt.gradle</b>
         */
        public KotlinKaptGradleLibraryAccessors getGradle() {
            return laccForKotlinKaptGradleLibraryAccessors;
        }

    }

    public static class KotlinKaptGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinKaptGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("kotlin.kapt.gradle.plugin");
        }

    }

    public static class KotlinSerializationLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KotlinSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>serialization</b> with <b>org.jetbrains.kotlin:kotlin-serialization</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("kotlin.serialization");
        }

        /**
         * Dependency provider for <b>json</b> with <b>org.jetbrains.kotlinx:kotlinx-serialization-json</b> coordinates and
         * with version reference <b>kotlinx.serialization.json</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("kotlin.serialization.json");
        }

    }

    public static class KotlinStdlibLibraryAccessors extends SubDependencyFactory {

        public KotlinStdlibLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdk8</b> with <b>org.jetbrains.kotlin:kotlin-stdlib-jdk8</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJdk8() {
            return create("kotlin.stdlib.jdk8");
        }

    }

    public static class KotlinTestLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KotlinTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>org.jetbrains.kotlin:kotlin-test</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("kotlin.test");
        }

        /**
         * Dependency provider for <b>junit</b> with <b>org.jetbrains.kotlin:kotlin-test-junit</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("kotlin.test.junit");
        }

        /**
         * Dependency provider for <b>junit5</b> with <b>org.jetbrains.kotlin:kotlin-test-junit5</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit5() {
            return create("kotlin.test.junit5");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>datetime</b> with <b>org.jetbrains.kotlinx:kotlinx-datetime</b> coordinates and
         * with version reference <b>kotlinx.datetime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatetime() {
            return create("kotlinx.datetime");
        }

        /**
         * Dependency provider for <b>uuid</b> with <b>app.softwork:kotlinx-uuid-core</b> coordinates and
         * with version reference <b>kotlinx.uuid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUuid() {
            return create("kotlinx.uuid");
        }

        /**
         * Group of libraries at <b>kotlinx.coroutines</b>
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-android</b> coordinates and
         * with version reference <b>kotlinx.coroutine</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("kotlinx.coroutines.android");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core</b> coordinates and
         * with version reference <b>kotlinx.coroutine</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("kotlinx.coroutines.core");
        }

        /**
         * Dependency provider for <b>reactor</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-reactor</b> coordinates and
         * with version reference <b>kotlinx.coroutine</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getReactor() {
            return create("kotlinx.coroutines.reactor");
        }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorClientLibraryAccessors laccForKtorClientLibraryAccessors = new KtorClientLibraryAccessors(owner);
        private final KtorSerializationLibraryAccessors laccForKtorSerializationLibraryAccessors = new KtorSerializationLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>ktor.client</b>
         */
        public KtorClientLibraryAccessors getClient() {
            return laccForKtorClientLibraryAccessors;
        }

        /**
         * Group of libraries at <b>ktor.serialization</b>
         */
        public KtorSerializationLibraryAccessors getSerialization() {
            return laccForKtorSerializationLibraryAccessors;
        }

    }

    public static class KtorClientLibraryAccessors extends SubDependencyFactory {
        private final KtorClientContentLibraryAccessors laccForKtorClientContentLibraryAccessors = new KtorClientContentLibraryAccessors(owner);

        public KtorClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>io.ktor:ktor-client-android</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("ktor.client.android");
        }

        /**
         * Dependency provider for <b>auth</b> with <b>io.ktor:ktor-client-auth</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAuth() {
            return create("ktor.client.auth");
        }

        /**
         * Dependency provider for <b>cio</b> with <b>io.ktor:ktor-client-cio</b> coordinates and
         * with version reference <b>ktor.client.cio</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCio() {
            return create("ktor.client.cio");
        }

        /**
         * Dependency provider for <b>core</b> with <b>io.ktor:ktor-client-core</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("ktor.client.core");
        }

        /**
         * Dependency provider for <b>logging</b> with <b>io.ktor:ktor-client-logging</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogging() {
            return create("ktor.client.logging");
        }

        /**
         * Group of libraries at <b>ktor.client.content</b>
         */
        public KtorClientContentLibraryAccessors getContent() {
            return laccForKtorClientContentLibraryAccessors;
        }

    }

    public static class KtorClientContentLibraryAccessors extends SubDependencyFactory {

        public KtorClientContentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>negotiation</b> with <b>io.ktor:ktor-client-content-negotiation</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNegotiation() {
            return create("ktor.client.content.negotiation");
        }

    }

    public static class KtorSerializationLibraryAccessors extends SubDependencyFactory {
        private final KtorSerializationKotlinxLibraryAccessors laccForKtorSerializationKotlinxLibraryAccessors = new KtorSerializationKotlinxLibraryAccessors(owner);

        public KtorSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>ktor.serialization.kotlinx</b>
         */
        public KtorSerializationKotlinxLibraryAccessors getKotlinx() {
            return laccForKtorSerializationKotlinxLibraryAccessors;
        }

    }

    public static class KtorSerializationKotlinxLibraryAccessors extends SubDependencyFactory {

        public KtorSerializationKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>io.ktor:ktor-serialization-kotlinx-json</b> coordinates and
         * with version reference <b>ktor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("ktor.serialization.kotlinx.json");
        }

    }

    public static class LoggingLibraryAccessors extends SubDependencyFactory {

        public LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>napier</b> with <b>io.github.aakira:napier</b> coordinates and
         * with version reference <b>napier</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNapier() {
            return create("logging.napier");
        }

    }

    public static class MapstructLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public MapstructLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mapstruct</b> with <b>org.mapstruct:mapstruct</b> coordinates and
         * with version reference <b>mapstruct</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("mapstruct");
        }

        /**
         * Dependency provider for <b>processor</b> with <b>org.mapstruct:mapstruct-processor</b> coordinates and
         * with version reference <b>mapstruct</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProcessor() {
            return create("mapstruct.processor");
        }

    }

    public static class MockLibraryAccessors extends SubDependencyFactory {
        private final MockServerLibraryAccessors laccForMockServerLibraryAccessors = new MockServerLibraryAccessors(owner);

        public MockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>mock.server</b>
         */
        public MockServerLibraryAccessors getServer() {
            return laccForMockServerLibraryAccessors;
        }

    }

    public static class MockServerLibraryAccessors extends SubDependencyFactory {
        private final MockServerClientLibraryAccessors laccForMockServerClientLibraryAccessors = new MockServerClientLibraryAccessors(owner);

        public MockServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>netty</b> with <b>org.mock-server:mockserver-netty</b> coordinates and
         * with version reference <b>mock.server</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNetty() {
            return create("mock.server.netty");
        }

        /**
         * Group of libraries at <b>mock.server.client</b>
         */
        public MockServerClientLibraryAccessors getClient() {
            return laccForMockServerClientLibraryAccessors;
        }

    }

    public static class MockServerClientLibraryAccessors extends SubDependencyFactory {

        public MockServerClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>org.mock-server:mockserver-client-java</b> coordinates and
         * with version reference <b>mock.server</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("mock.server.client.java");
        }

    }

    public static class ReactorLibraryAccessors extends SubDependencyFactory {
        private final ReactorKotlinLibraryAccessors laccForReactorKotlinLibraryAccessors = new ReactorKotlinLibraryAccessors(owner);

        public ReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>io.projectreactor:reactor-test</b> coordinates and
         * with version reference <b>reactor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("reactor.test");
        }

        /**
         * Group of libraries at <b>reactor.kotlin</b>
         */
        public ReactorKotlinLibraryAccessors getKotlin() {
            return laccForReactorKotlinLibraryAccessors;
        }

    }

    public static class ReactorKotlinLibraryAccessors extends SubDependencyFactory {

        public ReactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>extensions</b> with <b>io.projectreactor.kotlin:reactor-kotlin-extensions</b> coordinates and
         * with version reference <b>reactor.kotlin.extensions</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExtensions() {
            return create("reactor.kotlin.extensions");
        }

    }

    public static class SpringLibraryAccessors extends SubDependencyFactory {
        private final SpringBootLibraryAccessors laccForSpringBootLibraryAccessors = new SpringBootLibraryAccessors(owner);
        private final SpringCloudLibraryAccessors laccForSpringCloudLibraryAccessors = new SpringCloudLibraryAccessors(owner);
        private final SpringDataLibraryAccessors laccForSpringDataLibraryAccessors = new SpringDataLibraryAccessors(owner);
        private final SpringKafkaLibraryAccessors laccForSpringKafkaLibraryAccessors = new SpringKafkaLibraryAccessors(owner);
        private final SpringSecurityLibraryAccessors laccForSpringSecurityLibraryAccessors = new SpringSecurityLibraryAccessors(owner);

        public SpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tx</b> with <b>org.springframework:spring-tx</b> coordinates and
         * with version reference <b>spring.tx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTx() {
            return create("spring.tx");
        }

        /**
         * Group of libraries at <b>spring.boot</b>
         */
        public SpringBootLibraryAccessors getBoot() {
            return laccForSpringBootLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.cloud</b>
         */
        public SpringCloudLibraryAccessors getCloud() {
            return laccForSpringCloudLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.data</b>
         */
        public SpringDataLibraryAccessors getData() {
            return laccForSpringDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.kafka</b>
         */
        public SpringKafkaLibraryAccessors getKafka() {
            return laccForSpringKafkaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.security</b>
         */
        public SpringSecurityLibraryAccessors getSecurity() {
            return laccForSpringSecurityLibraryAccessors;
        }

    }

    public static class SpringBootLibraryAccessors extends SubDependencyFactory {
        private final SpringBootConfigurationLibraryAccessors laccForSpringBootConfigurationLibraryAccessors = new SpringBootConfigurationLibraryAccessors(owner);
        private final SpringBootGradleLibraryAccessors laccForSpringBootGradleLibraryAccessors = new SpringBootGradleLibraryAccessors(owner);
        private final SpringBootStarterLibraryAccessors laccForSpringBootStarterLibraryAccessors = new SpringBootStarterLibraryAccessors(owner);

        public SpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testcontainters</b> with <b>org.springframework.boot:spring-boot-testcontainers</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTestcontainters() {
            return create("spring.boot.testcontainters");
        }

        /**
         * Group of libraries at <b>spring.boot.configuration</b>
         */
        public SpringBootConfigurationLibraryAccessors getConfiguration() {
            return laccForSpringBootConfigurationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.boot.gradle</b>
         */
        public SpringBootGradleLibraryAccessors getGradle() {
            return laccForSpringBootGradleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.boot.starter</b>
         */
        public SpringBootStarterLibraryAccessors getStarter() {
            return laccForSpringBootStarterLibraryAccessors;
        }

    }

    public static class SpringBootConfigurationLibraryAccessors extends SubDependencyFactory {

        public SpringBootConfigurationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>processor</b> with <b>org.springframework.boot:spring-boot-configuration-processor</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProcessor() {
            return create("spring.boot.configuration.processor");
        }

    }

    public static class SpringBootGradleLibraryAccessors extends SubDependencyFactory {

        public SpringBootGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.springframework.boot:spring-boot-gradle-plugin</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("spring.boot.gradle.plugin");
        }

    }

    public static class SpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final SpringBootStarterDataLibraryAccessors laccForSpringBootStarterDataLibraryAccessors = new SpringBootStarterDataLibraryAccessors(owner);
        private final SpringBootStarterOauth2LibraryAccessors laccForSpringBootStarterOauth2LibraryAccessors = new SpringBootStarterOauth2LibraryAccessors(owner);

        public SpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>aop</b> with <b>org.springframework.boot:spring-boot-starter-aop</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAop() {
            return create("spring.boot.starter.aop");
        }

        /**
         * Dependency provider for <b>mail</b> with <b>org.springframework.boot:spring-boot-starter-mail</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMail() {
            return create("spring.boot.starter.mail");
        }

        /**
         * Dependency provider for <b>security</b> with <b>org.springframework.boot:spring-boot-starter-security</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSecurity() {
            return create("spring.boot.starter.security");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>validation</b> with <b>org.springframework.boot:spring-boot-starter-validation</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getValidation() {
            return create("spring.boot.starter.validation");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.boot:spring-boot-starter-web</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("spring.boot.starter.web");
        }

        /**
         * Dependency provider for <b>webflux</b> with <b>org.springframework.boot:spring-boot-starter-webflux</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWebflux() {
            return create("spring.boot.starter.webflux");
        }

        /**
         * Group of libraries at <b>spring.boot.starter.data</b>
         */
        public SpringBootStarterDataLibraryAccessors getData() {
            return laccForSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>spring.boot.starter.oauth2</b>
         */
        public SpringBootStarterOauth2LibraryAccessors getOauth2() {
            return laccForSpringBootStarterOauth2LibraryAccessors;
        }

    }

    public static class SpringBootStarterDataLibraryAccessors extends SubDependencyFactory {
        private final SpringBootStarterDataRedisLibraryAccessors laccForSpringBootStarterDataRedisLibraryAccessors = new SpringBootStarterDataRedisLibraryAccessors(owner);

        public SpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpa</b> with <b>org.springframework.boot:spring-boot-starter-data-jpa</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpa() {
            return create("spring.boot.starter.data.jpa");
        }

        /**
         * Dependency provider for <b>r2dbc</b> with <b>org.springframework.boot:spring-boot-starter-data-r2dbc</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getR2dbc() {
            return create("spring.boot.starter.data.r2dbc");
        }

        /**
         * Group of libraries at <b>spring.boot.starter.data.redis</b>
         */
        public SpringBootStarterDataRedisLibraryAccessors getRedis() {
            return laccForSpringBootStarterDataRedisLibraryAccessors;
        }

    }

    public static class SpringBootStarterDataRedisLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public SpringBootStarterDataRedisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>redis</b> with <b>org.springframework.boot:spring-boot-starter-data-redis</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("spring.boot.starter.data.redis");
        }

        /**
         * Dependency provider for <b>reactive</b> with <b>org.springframework.boot:spring-boot-starter-data-redis-reactive</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getReactive() {
            return create("spring.boot.starter.data.redis.reactive");
        }

    }

    public static class SpringBootStarterOauth2LibraryAccessors extends SubDependencyFactory {

        public SpringBootStarterOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>org.springframework.boot:spring-boot-starter-oauth2-client</b> coordinates and
         * with version reference <b>spring.boot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("spring.boot.starter.oauth2.client");
        }

    }

    public static class SpringCloudLibraryAccessors extends SubDependencyFactory {
        private final SpringCloudStarterLibraryAccessors laccForSpringCloudStarterLibraryAccessors = new SpringCloudStarterLibraryAccessors(owner);

        public SpringCloudLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>spring.cloud.starter</b>
         */
        public SpringCloudStarterLibraryAccessors getStarter() {
            return laccForSpringCloudStarterLibraryAccessors;
        }

    }

    public static class SpringCloudStarterLibraryAccessors extends SubDependencyFactory {

        public SpringCloudStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>aws</b> with <b>org.springframework.cloud:spring-cloud-starter-aws</b> coordinates and
         * with version reference <b>spring.aws</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAws() {
            return create("spring.cloud.starter.aws");
        }

        /**
         * Dependency provider for <b>openfeign</b> with <b>org.springframework.cloud:spring-cloud-starter-openfeign</b> coordinates and
         * with version reference <b>spring.openfeign</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOpenfeign() {
            return create("spring.cloud.starter.openfeign");
        }

    }

    public static class SpringDataLibraryAccessors extends SubDependencyFactory {
        private final SpringDataQuerydslLibraryAccessors laccForSpringDataQuerydslLibraryAccessors = new SpringDataQuerydslLibraryAccessors(owner);

        public SpringDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>spring.data.querydsl</b>
         */
        public SpringDataQuerydslLibraryAccessors getQuerydsl() {
            return laccForSpringDataQuerydslLibraryAccessors;
        }

    }

    public static class SpringDataQuerydslLibraryAccessors extends SubDependencyFactory {
        private final SpringDataQuerydslR2dbcLibraryAccessors laccForSpringDataQuerydslR2dbcLibraryAccessors = new SpringDataQuerydslR2dbcLibraryAccessors(owner);

        public SpringDataQuerydslLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>apt</b> with <b>com.querydsl:querydsl-apt</b> coordinates and
         * with version reference <b>spring.data.querydsl.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApt() {
            return create("spring.data.querydsl.apt");
        }

        /**
         * Dependency provider for <b>jpa</b> with <b>com.querydsl:querydsl-jpa</b> coordinates and
         * with version reference <b>spring.data.querydsl.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJpa() {
            return create("spring.data.querydsl.jpa");
        }

        /**
         * Group of libraries at <b>spring.data.querydsl.r2dbc</b>
         */
        public SpringDataQuerydslR2dbcLibraryAccessors getR2dbc() {
            return laccForSpringDataQuerydslR2dbcLibraryAccessors;
        }

    }

    public static class SpringDataQuerydslR2dbcLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final SpringDataQuerydslR2dbcAnnotationLibraryAccessors laccForSpringDataQuerydslR2dbcAnnotationLibraryAccessors = new SpringDataQuerydslR2dbcAnnotationLibraryAccessors(owner);

        public SpringDataQuerydslR2dbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>r2dbc</b> with <b>com.infobip:infobip-spring-data-r2dbc-querydsl-boot-starter</b> coordinates and
         * with version reference <b>spring.data.querydsl.r2dbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("spring.data.querydsl.r2dbc");
        }

        /**
         * Group of libraries at <b>spring.data.querydsl.r2dbc.annotation</b>
         */
        public SpringDataQuerydslR2dbcAnnotationLibraryAccessors getAnnotation() {
            return laccForSpringDataQuerydslR2dbcAnnotationLibraryAccessors;
        }

    }

    public static class SpringDataQuerydslR2dbcAnnotationLibraryAccessors extends SubDependencyFactory {

        public SpringDataQuerydslR2dbcAnnotationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>processor</b> with <b>com.infobip:infobip-spring-data-jdbc-annotation-processor</b> coordinates and
         * with version reference <b>spring.data.querydsl.r2dbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProcessor() {
            return create("spring.data.querydsl.r2dbc.annotation.processor");
        }

    }

    public static class SpringKafkaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public SpringKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.springframework.kafka:spring-kafka</b> coordinates and
         * with version reference <b>spring.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("spring.kafka");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.kafka:spring-kafka-test</b> coordinates and
         * with version reference <b>spring.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("spring.kafka.test");
        }

    }

    public static class SpringSecurityLibraryAccessors extends SubDependencyFactory {

        public SpringSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>config</b> with <b>org.springframework.security:spring-security-config</b> coordinates and
         * with version reference <b>spring.security</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConfig() {
            return create("spring.security.config");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.springframework.security:spring-security-core</b> coordinates and
         * with version reference <b>spring.security</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("spring.security.core");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.security:spring-security-test</b> coordinates and
         * with version reference <b>spring.security</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("spring.security.test");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.security:spring-security-web</b> coordinates and
         * with version reference <b>spring.security</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("spring.security.web");
        }

    }

    public static class SpringdocLibraryAccessors extends SubDependencyFactory {
        private final SpringdocOpenapiLibraryAccessors laccForSpringdocOpenapiLibraryAccessors = new SpringdocOpenapiLibraryAccessors(owner);

        public SpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>springdoc.openapi</b>
         */
        public SpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class SpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final SpringdocOpenapiStarterLibraryAccessors laccForSpringdocOpenapiStarterLibraryAccessors = new SpringdocOpenapiStarterLibraryAccessors(owner);

        public SpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>springdoc.openapi.starter</b>
         */
        public SpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class SpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final SpringdocOpenapiStarterWebmvcLibraryAccessors laccForSpringdocOpenapiStarterWebmvcLibraryAccessors = new SpringdocOpenapiStarterWebmvcLibraryAccessors(owner);

        public SpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>webflux</b> with <b>org.springdoc:springdoc-openapi-starter-webflux-ui</b> coordinates and
         * with version reference <b>springdoc.openapi.starter.webflux</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWebflux() {
            return create("springdoc.openapi.starter.webflux");
        }

        /**
         * Group of libraries at <b>springdoc.openapi.starter.webmvc</b>
         */
        public SpringdocOpenapiStarterWebmvcLibraryAccessors getWebmvc() {
            return laccForSpringdocOpenapiStarterWebmvcLibraryAccessors;
        }

    }

    public static class SpringdocOpenapiStarterWebmvcLibraryAccessors extends SubDependencyFactory {

        public SpringdocOpenapiStarterWebmvcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>org.springdoc:springdoc-openapi-starter-webmvc-ui</b> coordinates and
         * with version reference <b>springdoc.openapi.starter.webmvc.ui</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("springdoc.openapi.starter.webmvc.ui");
        }

    }

    public static class TestcontainersLibraryAccessors extends SubDependencyFactory {
        private final TestcontainersJunitLibraryAccessors laccForTestcontainersJunitLibraryAccessors = new TestcontainersJunitLibraryAccessors(owner);

        public TestcontainersLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mockserver</b> with <b>org.testcontainers:mockserver</b> coordinates and
         * with version reference <b>testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMockserver() {
            return create("testcontainers.mockserver");
        }

        /**
         * Dependency provider for <b>mysql</b> with <b>org.testcontainers:mysql</b> coordinates and
         * with version reference <b>testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMysql() {
            return create("testcontainers.mysql");
        }

        /**
         * Dependency provider for <b>r2dbc</b> with <b>org.testcontainers:r2dbc</b> coordinates and
         * with version reference <b>testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getR2dbc() {
            return create("testcontainers.r2dbc");
        }

        /**
         * Group of libraries at <b>testcontainers.junit</b>
         */
        public TestcontainersJunitLibraryAccessors getJunit() {
            return laccForTestcontainersJunitLibraryAccessors;
        }

    }

    public static class TestcontainersJunitLibraryAccessors extends SubDependencyFactory {

        public TestcontainersJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jupiter</b> with <b>org.testcontainers:junit-jupiter</b> coordinates and
         * with version reference <b>testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJupiter() {
            return create("testcontainers.junit.jupiter");
        }

    }

    public static class TikaLibraryAccessors extends SubDependencyFactory {

        public TikaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.tika:tika-core</b> coordinates and
         * with version reference <b>tika.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("tika.core");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final H2VersionAccessors vaccForH2VersionAccessors = new H2VersionAccessors(providers, config);
        private final JakartaVersionAccessors vaccForJakartaVersionAccessors = new JakartaVersionAccessors(providers, config);
        private final KotestVersionAccessors vaccForKotestVersionAccessors = new KotestVersionAccessors(providers, config);
        private final KotlinVersionAccessors vaccForKotlinVersionAccessors = new KotlinVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        private final KtorVersionAccessors vaccForKtorVersionAccessors = new KtorVersionAccessors(providers, config);
        private final MockVersionAccessors vaccForMockVersionAccessors = new MockVersionAccessors(providers, config);
        private final MysqlVersionAccessors vaccForMysqlVersionAccessors = new MysqlVersionAccessors(providers, config);
        private final ReactorVersionAccessors vaccForReactorVersionAccessors = new ReactorVersionAccessors(providers, config);
        private final SpringVersionAccessors vaccForSpringVersionAccessors = new SpringVersionAccessors(providers, config);
        private final SpringdocVersionAccessors vaccForSpringdocVersionAccessors = new SpringdocVersionAccessors(providers, config);
        private final TikaVersionAccessors vaccForTikaVersionAccessors = new TikaVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>flyway</b> with value <b>10.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFlyway() { return getVersion("flyway"); }

        /**
         * Version alias <b>hamcrest</b> with value <b>2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHamcrest() { return getVersion("hamcrest"); }

        /**
         * Version alias <b>jackson</b> with value <b>2.16.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJackson() { return getVersion("jackson"); }

        /**
         * Version alias <b>jjwt</b> with value <b>0.12.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJjwt() { return getVersion("jjwt"); }

        /**
         * Version alias <b>junit</b> with value <b>5.10.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Version alias <b>mapstruct</b> with value <b>1.5.5.Final</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMapstruct() { return getVersion("mapstruct"); }

        /**
         * Version alias <b>mockk</b> with value <b>1.13.10</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMockk() { return getVersion("mockk"); }

        /**
         * Version alias <b>napier</b> with value <b>2.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNapier() { return getVersion("napier"); }

        /**
         * Version alias <b>springmockk</b> with value <b>4.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpringmockk() { return getVersion("springmockk"); }

        /**
         * Version alias <b>testcontainers</b> with value <b>1.19.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTestcontainers() { return getVersion("testcontainers"); }

        /**
         * Group of versions at <b>versions.commons</b>
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.h2</b>
         */
        public H2VersionAccessors getH2() {
            return vaccForH2VersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta</b>
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotest</b>
         */
        public KotestVersionAccessors getKotest() {
            return vaccForKotestVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlin</b>
         */
        public KotlinVersionAccessors getKotlin() {
            return vaccForKotlinVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlinx</b>
         */
        public KotlinxVersionAccessors getKotlinx() {
            return vaccForKotlinxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.ktor</b>
         */
        public KtorVersionAccessors getKtor() {
            return vaccForKtorVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.mock</b>
         */
        public MockVersionAccessors getMock() {
            return vaccForMockVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.mysql</b>
         */
        public MysqlVersionAccessors getMysql() {
            return vaccForMysqlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.reactor</b>
         */
        public ReactorVersionAccessors getReactor() {
            return vaccForReactorVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.spring</b>
         */
        public SpringVersionAccessors getSpring() {
            return vaccForSpringVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.springdoc</b>
         */
        public SpringdocVersionAccessors getSpringdoc() {
            return vaccForSpringdocVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.tika</b>
         */
        public TikaVersionAccessors getTika() {
            return vaccForTikaVersionAccessors;
        }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>commons.codec</b> with value <b>1.16.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCodec() { return getVersion("commons.codec"); }

    }

    public static class H2VersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public H2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>h2</b> with value <b>2.1.214</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("h2"); }

        /**
         * Version alias <b>h2.r2dbc</b> with value <b>1.0.0.RELEASE</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getR2dbc() { return getVersion("h2.r2dbc"); }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaServletVersionAccessors vaccForJakartaServletVersionAccessors = new JakartaServletVersionAccessors(providers, config);
        private final JakartaValidationVersionAccessors vaccForJakartaValidationVersionAccessors = new JakartaValidationVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet</b>
         */
        public JakartaServletVersionAccessors getServlet() {
            return vaccForJakartaServletVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.validation</b>
         */
        public JakartaValidationVersionAccessors getValidation() {
            return vaccForJakartaValidationVersionAccessors;
        }

    }

    public static class JakartaServletVersionAccessors extends VersionFactory  {

        public JakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.servlet.api</b> with value <b>6.1.0-M2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.servlet.api"); }

    }

    public static class JakartaValidationVersionAccessors extends VersionFactory  {

        public JakartaValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.validation.api</b> with value <b>3.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.validation.api"); }

    }

    public static class KotestVersionAccessors extends VersionFactory  {

        private final KotestExtensionsVersionAccessors vaccForKotestExtensionsVersionAccessors = new KotestExtensionsVersionAccessors(providers, config);
        private final KotestRunnerVersionAccessors vaccForKotestRunnerVersionAccessors = new KotestRunnerVersionAccessors(providers, config);
        public KotestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.kotest.extensions</b>
         */
        public KotestExtensionsVersionAccessors getExtensions() {
            return vaccForKotestExtensionsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotest.runner</b>
         */
        public KotestRunnerVersionAccessors getRunner() {
            return vaccForKotestRunnerVersionAccessors;
        }

    }

    public static class KotestExtensionsVersionAccessors extends VersionFactory  {

        private final KotestExtensionsMockVersionAccessors vaccForKotestExtensionsMockVersionAccessors = new KotestExtensionsMockVersionAccessors(providers, config);
        public KotestExtensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotest.extensions.spring</b> with value <b>1.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpring() { return getVersion("kotest.extensions.spring"); }

        /**
         * Version alias <b>kotest.extensions.testcontainers</b> with value <b>2.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTestcontainers() { return getVersion("kotest.extensions.testcontainers"); }

        /**
         * Group of versions at <b>versions.kotest.extensions.mock</b>
         */
        public KotestExtensionsMockVersionAccessors getMock() {
            return vaccForKotestExtensionsMockVersionAccessors;
        }

    }

    public static class KotestExtensionsMockVersionAccessors extends VersionFactory  {

        public KotestExtensionsMockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotest.extensions.mock.server</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getServer() { return getVersion("kotest.extensions.mock.server"); }

    }

    public static class KotestRunnerVersionAccessors extends VersionFactory  {

        public KotestRunnerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotest.runner.junit5</b> with value <b>5.8.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit5() { return getVersion("kotest.runner.junit5"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin</b> with value <b>1.9.24</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("kotlin"); }

        /**
         * Version alias <b>kotlin.logging</b> with value <b>6.0.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLogging() { return getVersion("kotlin.logging"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        private final KotlinxSerializationVersionAccessors vaccForKotlinxSerializationVersionAccessors = new KotlinxSerializationVersionAccessors(providers, config);
        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.coroutine</b> with value <b>1.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoroutine() { return getVersion("kotlinx.coroutine"); }

        /**
         * Version alias <b>kotlinx.datetime</b> with value <b>0.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDatetime() { return getVersion("kotlinx.datetime"); }

        /**
         * Version alias <b>kotlinx.uuid</b> with value <b>0.0.25</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUuid() { return getVersion("kotlinx.uuid"); }

        /**
         * Group of versions at <b>versions.kotlinx.serialization</b>
         */
        public KotlinxSerializationVersionAccessors getSerialization() {
            return vaccForKotlinxSerializationVersionAccessors;
        }

    }

    public static class KotlinxSerializationVersionAccessors extends VersionFactory  {

        public KotlinxSerializationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.serialization.json</b> with value <b>1.6.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJson() { return getVersion("kotlinx.serialization.json"); }

    }

    public static class KtorVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final KtorClientVersionAccessors vaccForKtorClientVersionAccessors = new KtorClientVersionAccessors(providers, config);
        public KtorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>ktor</b> with value <b>2.3.11</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("ktor"); }

        /**
         * Group of versions at <b>versions.ktor.client</b>
         */
        public KtorClientVersionAccessors getClient() {
            return vaccForKtorClientVersionAccessors;
        }

    }

    public static class KtorClientVersionAccessors extends VersionFactory  {

        public KtorClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>ktor.client.cio</b> with value <b>2.3.11</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCio() { return getVersion("ktor.client.cio"); }

    }

    public static class MockVersionAccessors extends VersionFactory  {

        public MockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>mock.server</b> with value <b>5.15.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getServer() { return getVersion("mock.server"); }

    }

    public static class MysqlVersionAccessors extends VersionFactory  {

        public MysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>mysql.jpa</b> with value <b>8.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpa() { return getVersion("mysql.jpa"); }

        /**
         * Version alias <b>mysql.r2dbc</b> with value <b>1.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getR2dbc() { return getVersion("mysql.r2dbc"); }

    }

    public static class ReactorVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final ReactorKotlinVersionAccessors vaccForReactorKotlinVersionAccessors = new ReactorKotlinVersionAccessors(providers, config);
        public ReactorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>reactor</b> with value <b>3.6.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("reactor"); }

        /**
         * Group of versions at <b>versions.reactor.kotlin</b>
         */
        public ReactorKotlinVersionAccessors getKotlin() {
            return vaccForReactorKotlinVersionAccessors;
        }

    }

    public static class ReactorKotlinVersionAccessors extends VersionFactory  {

        public ReactorKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>reactor.kotlin.extensions</b> with value <b>1.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getExtensions() { return getVersion("reactor.kotlin.extensions"); }

    }

    public static class SpringVersionAccessors extends VersionFactory  {

        private final SpringDataVersionAccessors vaccForSpringDataVersionAccessors = new SpringDataVersionAccessors(providers, config);
        private final SpringDependencyVersionAccessors vaccForSpringDependencyVersionAccessors = new SpringDependencyVersionAccessors(providers, config);
        public SpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>spring.aws</b> with value <b>2.2.6.RELEASE</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAws() { return getVersion("spring.aws"); }

        /**
         * Version alias <b>spring.boot</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBoot() { return getVersion("spring.boot"); }

        /**
         * Version alias <b>spring.kafka</b> with value <b>3.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKafka() { return getVersion("spring.kafka"); }

        /**
         * Version alias <b>spring.openfeign</b> with value <b>4.1.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOpenfeign() { return getVersion("spring.openfeign"); }

        /**
         * Version alias <b>spring.security</b> with value <b>6.2.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSecurity() { return getVersion("spring.security"); }

        /**
         * Version alias <b>spring.tx</b> with value <b>6.1.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTx() { return getVersion("spring.tx"); }

        /**
         * Group of versions at <b>versions.spring.data</b>
         */
        public SpringDataVersionAccessors getData() {
            return vaccForSpringDataVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.spring.dependency</b>
         */
        public SpringDependencyVersionAccessors getDependency() {
            return vaccForSpringDependencyVersionAccessors;
        }

    }

    public static class SpringDataVersionAccessors extends VersionFactory  {

        private final SpringDataQuerydslVersionAccessors vaccForSpringDataQuerydslVersionAccessors = new SpringDataQuerydslVersionAccessors(providers, config);
        public SpringDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.spring.data.querydsl</b>
         */
        public SpringDataQuerydslVersionAccessors getQuerydsl() {
            return vaccForSpringDataQuerydslVersionAccessors;
        }

    }

    public static class SpringDataQuerydslVersionAccessors extends VersionFactory  {

        public SpringDataQuerydslVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>spring.data.querydsl.jpa</b> with value <b>5.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpa() { return getVersion("spring.data.querydsl.jpa"); }

        /**
         * Version alias <b>spring.data.querydsl.r2dbc</b> with value <b>9.0.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getR2dbc() { return getVersion("spring.data.querydsl.r2dbc"); }

    }

    public static class SpringDependencyVersionAccessors extends VersionFactory  {

        public SpringDependencyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>spring.dependency.management</b> with value <b>1.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getManagement() { return getVersion("spring.dependency.management"); }

    }

    public static class SpringdocVersionAccessors extends VersionFactory  {

        private final SpringdocOpenapiVersionAccessors vaccForSpringdocOpenapiVersionAccessors = new SpringdocOpenapiVersionAccessors(providers, config);
        public SpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.springdoc.openapi</b>
         */
        public SpringdocOpenapiVersionAccessors getOpenapi() {
            return vaccForSpringdocOpenapiVersionAccessors;
        }

    }

    public static class SpringdocOpenapiVersionAccessors extends VersionFactory  {

        private final SpringdocOpenapiStarterVersionAccessors vaccForSpringdocOpenapiStarterVersionAccessors = new SpringdocOpenapiStarterVersionAccessors(providers, config);
        public SpringdocOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.springdoc.openapi.starter</b>
         */
        public SpringdocOpenapiStarterVersionAccessors getStarter() {
            return vaccForSpringdocOpenapiStarterVersionAccessors;
        }

    }

    public static class SpringdocOpenapiStarterVersionAccessors extends VersionFactory  {

        private final SpringdocOpenapiStarterWebmvcVersionAccessors vaccForSpringdocOpenapiStarterWebmvcVersionAccessors = new SpringdocOpenapiStarterWebmvcVersionAccessors(providers, config);
        public SpringdocOpenapiStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>springdoc.openapi.starter.webflux</b> with value <b>2.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWebflux() { return getVersion("springdoc.openapi.starter.webflux"); }

        /**
         * Group of versions at <b>versions.springdoc.openapi.starter.webmvc</b>
         */
        public SpringdocOpenapiStarterWebmvcVersionAccessors getWebmvc() {
            return vaccForSpringdocOpenapiStarterWebmvcVersionAccessors;
        }

    }

    public static class SpringdocOpenapiStarterWebmvcVersionAccessors extends VersionFactory  {

        public SpringdocOpenapiStarterWebmvcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>springdoc.openapi.starter.webmvc.ui</b> with value <b>2.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUi() { return getVersion("springdoc.openapi.starter.webmvc.ui"); }

    }

    public static class TikaVersionAccessors extends VersionFactory  {

        public TikaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>tika.core</b> with value <b>2.9.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("tika.core"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final CommonsBundleAccessors baccForCommonsBundleAccessors = new CommonsBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesBundleAccessors baccForModulesBundleAccessors = new ModulesBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ProjectBundleAccessors baccForProjectBundleAccessors = new ProjectBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final TestBundleAccessors baccForTestBundleAccessors = new TestBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.commons</b>
         */
        public CommonsBundleAccessors getCommons() {
            return baccForCommonsBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules</b>
         */
        public ModulesBundleAccessors getModules() {
            return baccForModulesBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.project</b>
         */
        public ProjectBundleAccessors getProject() {
            return baccForProjectBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.test</b>
         */
        public TestBundleAccessors getTest() {
            return baccForTestBundleAccessors;
        }

    }

    public static class CommonsBundleAccessors extends BundleFactory {
        private final CommonsInfrastructureBundleAccessors baccForCommonsInfrastructureBundleAccessors = new CommonsInfrastructureBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final CommonsProjectBundleAccessors baccForCommonsProjectBundleAccessors = new CommonsProjectBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public CommonsBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>commons.common</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getCommon() {
            return createBundle("commons.common");
        }

        /**
         * Group of bundles at <b>bundles.commons.infrastructure</b>
         */
        public CommonsInfrastructureBundleAccessors getInfrastructure() {
            return baccForCommonsInfrastructureBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.commons.project</b>
         */
        public CommonsProjectBundleAccessors getProject() {
            return baccForCommonsProjectBundleAccessors;
        }

    }

    public static class CommonsInfrastructureBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public CommonsInfrastructureBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>commons.infrastructure</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>org.springframework.security:spring-security-core</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jdk8</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</li>
         *    <li>com.fasterxml.jackson.module:jackson-module-kotlin</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("commons.infrastructure");
        }

        /**
         * Dependency bundle provider for <b>commons.infrastructure.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("commons.infrastructure.test");
        }

    }

    public static class CommonsProjectBundleAccessors extends BundleFactory {
        private final CommonsProjectDudgnsBundleAccessors baccForCommonsProjectDudgnsBundleAccessors = new CommonsProjectDudgnsBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public CommonsProjectBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.commons.project.dudgns</b>
         */
        public CommonsProjectDudgnsBundleAccessors getDudgns() {
            return baccForCommonsProjectDudgnsBundleAccessors;
        }

    }

    public static class CommonsProjectDudgnsBundleAccessors extends BundleFactory {
        private final CommonsProjectDudgnsDataBundleAccessors baccForCommonsProjectDudgnsDataBundleAccessors = new CommonsProjectDudgnsDataBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public CommonsProjectDudgnsBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.commons.project.dudgns.data</b>
         */
        public CommonsProjectDudgnsDataBundleAccessors getData() {
            return baccForCommonsProjectDudgnsDataBundleAccessors;
        }

    }

    public static class CommonsProjectDudgnsDataBundleAccessors extends BundleFactory {
        private final CommonsProjectDudgnsDataEntityBundleAccessors baccForCommonsProjectDudgnsDataEntityBundleAccessors = new CommonsProjectDudgnsDataEntityBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public CommonsProjectDudgnsDataBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.commons.project.dudgns.data.entity</b>
         */
        public CommonsProjectDudgnsDataEntityBundleAccessors getEntity() {
            return baccForCommonsProjectDudgnsDataEntityBundleAccessors;
        }

    }

    public static class CommonsProjectDudgnsDataEntityBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public CommonsProjectDudgnsDataEntityBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>commons.project.dudgns.data.entity</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-data-jpa</li>
         *    <li>com.mysql:mysql-connector-j</li>
         *    <li>jakarta.validation:jakarta.validation-api</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("commons.project.dudgns.data.entity");
        }

        /**
         * Dependency bundle provider for <b>commons.project.dudgns.data.entity.kapt</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-configuration-processor</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getKapt() {
            return createBundle("commons.project.dudgns.data.entity.kapt");
        }

        /**
         * Dependency bundle provider for <b>commons.project.dudgns.data.entity.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("commons.project.dudgns.data.entity.test");
        }

    }

    public static class ModulesBundleAccessors extends BundleFactory {
        private final ModulesAopBundleAccessors baccForModulesAopBundleAccessors = new ModulesAopBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesAuthBundleAccessors baccForModulesAuthBundleAccessors = new ModulesAuthBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesAwsBundleAccessors baccForModulesAwsBundleAccessors = new ModulesAwsBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesCacheBundleAccessors baccForModulesCacheBundleAccessors = new ModulesCacheBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesMessageBundleAccessors baccForModulesMessageBundleAccessors = new ModulesMessageBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesPgBundleAccessors baccForModulesPgBundleAccessors = new ModulesPgBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesRedisBundleAccessors baccForModulesRedisBundleAccessors = new ModulesRedisBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.common</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getCommon() {
            return createBundle("modules.common");
        }

        /**
         * Group of bundles at <b>bundles.modules.aop</b>
         */
        public ModulesAopBundleAccessors getAop() {
            return baccForModulesAopBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.auth</b>
         */
        public ModulesAuthBundleAccessors getAuth() {
            return baccForModulesAuthBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.aws</b>
         */
        public ModulesAwsBundleAccessors getAws() {
            return baccForModulesAwsBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.cache</b>
         */
        public ModulesCacheBundleAccessors getCache() {
            return baccForModulesCacheBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.message</b>
         */
        public ModulesMessageBundleAccessors getMessage() {
            return baccForModulesMessageBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.pg</b>
         */
        public ModulesPgBundleAccessors getPg() {
            return baccForModulesPgBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.redis</b>
         */
        public ModulesRedisBundleAccessors getRedis() {
            return baccForModulesRedisBundleAccessors;
        }

    }

    public static class ModulesAopBundleAccessors extends BundleFactory {
        private final ModulesAopLoggingBundleAccessors baccForModulesAopLoggingBundleAccessors = new ModulesAopLoggingBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesAopBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.modules.aop.logging</b>
         */
        public ModulesAopLoggingBundleAccessors getLogging() {
            return baccForModulesAopLoggingBundleAccessors;
        }

    }

    public static class ModulesAopLoggingBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesAopLoggingClientBundleAccessors baccForModulesAopLoggingClientBundleAccessors = new ModulesAopLoggingClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesAopLoggingBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.aop.logging</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.aop.logging");
        }

        /**
         * Group of bundles at <b>bundles.modules.aop.logging.client</b>
         */
        public ModulesAopLoggingClientBundleAccessors getClient() {
            return baccForModulesAopLoggingClientBundleAccessors;
        }

    }

    public static class ModulesAopLoggingClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesAopLoggingClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.aop.logging.client</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>org.springframework.boot:spring-boot-starter-aop</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.aop.logging.client");
        }

        /**
         * Dependency bundle provider for <b>modules.aop.logging.client.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.aop.logging.client.test");
        }

    }

    public static class ModulesAuthBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesAuthApiBundleAccessors baccForModulesAuthApiBundleAccessors = new ModulesAuthApiBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ModulesAuthClientBundleAccessors baccForModulesAuthClientBundleAccessors = new ModulesAuthClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesAuthBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.auth</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.auth");
        }

        /**
         * Group of bundles at <b>bundles.modules.auth.api</b>
         */
        public ModulesAuthApiBundleAccessors getApi() {
            return baccForModulesAuthApiBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.modules.auth.client</b>
         */
        public ModulesAuthClientBundleAccessors getClient() {
            return baccForModulesAuthClientBundleAccessors;
        }

    }

    public static class ModulesAuthApiBundleAccessors extends BundleFactory {
        private final ModulesAuthApiClientBundleAccessors baccForModulesAuthApiClientBundleAccessors = new ModulesAuthApiClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesAuthApiBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.modules.auth.api.client</b>
         */
        public ModulesAuthApiClientBundleAccessors getClient() {
            return baccForModulesAuthApiClientBundleAccessors;
        }

    }

    public static class ModulesAuthApiClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesAuthApiClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.auth.api.client</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>org.springframework.security:spring-security-core</li>
         *    <li>org.springframework.security:spring-security-config</li>
         *    <li>org.springframework.security:spring-security-web</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.auth.api.client");
        }

        /**
         * Dependency bundle provider for <b>modules.auth.api.client.test</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.security:spring-security-test</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.auth.api.client.test");
        }

    }

    public static class ModulesAuthClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesAuthClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.auth.client</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>org.springframework.security:spring-security-core</li>
         *    <li>org.springframework.security:spring-security-config</li>
         *    <li>org.springframework.security:spring-security-web</li>
         *    <li>com.fasterxml.jackson.module:jackson-module-kotlin</li>
         *    <li>io.jsonwebtoken:jjwt-api</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.auth.client");
        }

        /**
         * Dependency bundle provider for <b>modules.auth.client.runtime</b> which contains the following dependencies:
         * <ul>
         *    <li>io.jsonwebtoken:jjwt-impl</li>
         *    <li>io.jsonwebtoken:jjwt-jackson</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getRuntime() {
            return createBundle("modules.auth.client.runtime");
        }

        /**
         * Dependency bundle provider for <b>modules.auth.client.test</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.security:spring-security-test</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.auth.client.test");
        }

    }

    public static class ModulesAwsBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesAwsBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.aws</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.cloud:spring-cloud-starter-aws</li>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.aws");
        }

        /**
         * Dependency bundle provider for <b>modules.aws.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.aws.test");
        }

    }

    public static class ModulesCacheBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesCacheClientBundleAccessors baccForModulesCacheClientBundleAccessors = new ModulesCacheClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesCacheBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.cache</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.cache");
        }

        /**
         * Group of bundles at <b>bundles.modules.cache.client</b>
         */
        public ModulesCacheClientBundleAccessors getClient() {
            return baccForModulesCacheClientBundleAccessors;
        }

    }

    public static class ModulesCacheClientBundleAccessors extends BundleFactory {

        public ModulesCacheClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.cache.client.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.cache.client.test");
        }

    }

    public static class ModulesMessageBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesMessageClientBundleAccessors baccForModulesMessageClientBundleAccessors = new ModulesMessageClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesMessageBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.message</b> which contains the following dependencies:
         * <ul>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jdk8</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</li>
         *    <li>org.jetbrains.kotlinx:kotlinx-serialization-json</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.message");
        }

        /**
         * Group of bundles at <b>bundles.modules.message.client</b>
         */
        public ModulesMessageClientBundleAccessors getClient() {
            return baccForModulesMessageClientBundleAccessors;
        }

    }

    public static class ModulesMessageClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesMessageClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.message.client</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>com.fasterxml.jackson.module:jackson-module-kotlin</li>
         *    <li>org.mapstruct:mapstruct</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.message.client");
        }

        /**
         * Dependency bundle provider for <b>modules.message.client.kapt</b> which contains the following dependencies:
         * <ul>
         *    <li>org.mapstruct:mapstruct-processor</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getKapt() {
            return createBundle("modules.message.client.kapt");
        }

        /**
         * Dependency bundle provider for <b>modules.message.client.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.message.client.test");
        }

    }

    public static class ModulesPgBundleAccessors extends BundleFactory {
        private final ModulesPgWelcomeBundleAccessors baccForModulesPgWelcomeBundleAccessors = new ModulesPgWelcomeBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesPgBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.modules.pg.welcome</b>
         */
        public ModulesPgWelcomeBundleAccessors getWelcome() {
            return baccForModulesPgWelcomeBundleAccessors;
        }

    }

    public static class ModulesPgWelcomeBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesPgWelcomeClientBundleAccessors baccForModulesPgWelcomeClientBundleAccessors = new ModulesPgWelcomeClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesPgWelcomeBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.pg.welcome</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.pg.welcome");
        }

        /**
         * Group of bundles at <b>bundles.modules.pg.welcome.client</b>
         */
        public ModulesPgWelcomeClientBundleAccessors getClient() {
            return baccForModulesPgWelcomeClientBundleAccessors;
        }

    }

    public static class ModulesPgWelcomeClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesPgWelcomeClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.pg.welcome.client</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>commons-codec:commons-codec</li>
         *    <li>org.springframework.cloud:spring-cloud-starter-openfeign</li>
         *    <li>org.springdoc:springdoc-openapi-starter-webmvc-ui</li>
         *    <li>org.mapstruct:mapstruct</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.pg.welcome.client");
        }

        /**
         * Dependency bundle provider for <b>modules.pg.welcome.client.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.pg.welcome.client.test");
        }

    }

    public static class ModulesRedisBundleAccessors extends BundleFactory  implements BundleNotationSupplier{
        private final ModulesRedisClientBundleAccessors baccForModulesRedisClientBundleAccessors = new ModulesRedisClientBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ModulesRedisBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.redis</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.redis");
        }

        /**
         * Group of bundles at <b>bundles.modules.redis.client</b>
         */
        public ModulesRedisClientBundleAccessors getClient() {
            return baccForModulesRedisClientBundleAccessors;
        }

    }

    public static class ModulesRedisClientBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ModulesRedisClientBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>modules.redis.client</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("modules.redis.client");
        }

        /**
         * Dependency bundle provider for <b>modules.redis.client.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("modules.redis.client.test");
        }

    }

    public static class ProjectBundleAccessors extends BundleFactory {
        private final ProjectCarBundleAccessors baccForProjectCarBundleAccessors = new ProjectCarBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ProjectBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.project.car</b>
         */
        public ProjectCarBundleAccessors getCar() {
            return baccForProjectCarBundleAccessors;
        }

    }

    public static class ProjectCarBundleAccessors extends BundleFactory {
        private final ProjectCarMgtBundleAccessors baccForProjectCarMgtBundleAccessors = new ProjectCarMgtBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ProjectCarBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.project.car.mgt</b>
         */
        public ProjectCarMgtBundleAccessors getMgt() {
            return baccForProjectCarMgtBundleAccessors;
        }

    }

    public static class ProjectCarMgtBundleAccessors extends BundleFactory {
        private final ProjectCarMgtAdapterBundleAccessors baccForProjectCarMgtAdapterBundleAccessors = new ProjectCarMgtAdapterBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ProjectCarMgtApplicationBundleAccessors baccForProjectCarMgtApplicationBundleAccessors = new ProjectCarMgtApplicationBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
        private final ProjectCarMgtConnectorBundleAccessors baccForProjectCarMgtConnectorBundleAccessors = new ProjectCarMgtConnectorBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ProjectCarMgtBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>project.car.mgt.admin</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getAdmin() {
            return createBundle("project.car.mgt.admin");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.bootstrap</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getBootstrap() {
            return createBundle("project.car.mgt.bootstrap");
        }

        /**
         * Group of bundles at <b>bundles.project.car.mgt.adapter</b>
         */
        public ProjectCarMgtAdapterBundleAccessors getAdapter() {
            return baccForProjectCarMgtAdapterBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.project.car.mgt.application</b>
         */
        public ProjectCarMgtApplicationBundleAccessors getApplication() {
            return baccForProjectCarMgtApplicationBundleAccessors;
        }

        /**
         * Group of bundles at <b>bundles.project.car.mgt.connector</b>
         */
        public ProjectCarMgtConnectorBundleAccessors getConnector() {
            return baccForProjectCarMgtConnectorBundleAccessors;
        }

    }

    public static class ProjectCarMgtAdapterBundleAccessors extends BundleFactory {
        private final ProjectCarMgtAdapterDataBundleAccessors baccForProjectCarMgtAdapterDataBundleAccessors = new ProjectCarMgtAdapterDataBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ProjectCarMgtAdapterBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.project.car.mgt.adapter.data</b>
         */
        public ProjectCarMgtAdapterDataBundleAccessors getData() {
            return baccForProjectCarMgtAdapterDataBundleAccessors;
        }

    }

    public static class ProjectCarMgtAdapterDataBundleAccessors extends BundleFactory {
        private final ProjectCarMgtAdapterDataJpaBundleAccessors baccForProjectCarMgtAdapterDataJpaBundleAccessors = new ProjectCarMgtAdapterDataJpaBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public ProjectCarMgtAdapterDataBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Group of bundles at <b>bundles.project.car.mgt.adapter.data.jpa</b>
         */
        public ProjectCarMgtAdapterDataJpaBundleAccessors getJpa() {
            return baccForProjectCarMgtAdapterDataJpaBundleAccessors;
        }

    }

    public static class ProjectCarMgtAdapterDataJpaBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ProjectCarMgtAdapterDataJpaBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>project.car.mgt.adapter.data.jpa</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-data-jpa</li>
         *    <li>com.mysql:mysql-connector-j</li>
         *    <li>jakarta.validation:jakarta.validation-api</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jdk8</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</li>
         *    <li>com.fasterxml.jackson.module:jackson-module-kotlin</li>
         *    <li>com.fasterxml.jackson.core:jackson-core</li>
         *    <li>com.fasterxml.jackson.core:jackson-databind</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("project.car.mgt.adapter.data.jpa");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.adapter.data.jpa.kapt</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-configuration-processor</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getKapt() {
            return createBundle("project.car.mgt.adapter.data.jpa.kapt");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.adapter.data.jpa.test</b> which contains the following dependencies:
         * <ul>
         *    <li>org.flywaydb:flyway-core</li>
         *    <li>org.flywaydb:flyway-mysql</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("project.car.mgt.adapter.data.jpa.test");
        }

    }

    public static class ProjectCarMgtApplicationBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ProjectCarMgtApplicationBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>project.car.mgt.application</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("project.car.mgt.application");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.application.test</b> which contains no dependencies
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("project.car.mgt.application.test");
        }

    }

    public static class ProjectCarMgtConnectorBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ProjectCarMgtConnectorBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>project.car.mgt.connector</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-web</li>
         *    <li>org.springframework.boot:spring-boot-starter-validation</li>
         *    <li>jakarta.validation:jakarta.validation-api</li>
         *    <li>org.springdoc:springdoc-openapi-starter-webmvc-ui</li>
         *    <li>org.springframework:spring-tx</li>
         *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-reactor</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jdk8</li>
         *    <li>com.fasterxml.jackson.datatype:jackson-datatype-jsr310</li>
         *    <li>com.fasterxml.jackson.module:jackson-module-kotlin</li>
         *    <li>com.fasterxml.jackson.core:jackson-core</li>
         *    <li>com.fasterxml.jackson.core:jackson-databind</li>
         *    <li>org.mapstruct:mapstruct</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("project.car.mgt.connector");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.connector.kapt</b> which contains the following dependencies:
         * <ul>
         *    <li>org.mapstruct:mapstruct-processor</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getKapt() {
            return createBundle("project.car.mgt.connector.kapt");
        }

        /**
         * Dependency bundle provider for <b>project.car.mgt.connector.test</b> which contains the following dependencies:
         * <ul>
         *    <li>org.springframework.boot:spring-boot-starter-webflux</li>
         *    <li>org.mock-server:mockserver-netty</li>
         *    <li>org.mock-server:mockserver-client-java</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getTest() {
            return createBundle("project.car.mgt.connector.test");
        }

    }

    public static class TestBundleAccessors extends BundleFactory {

        public TestBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>test.junit</b> which contains the following dependencies:
         * <ul>
         *    <li>io.mockk:mockk</li>
         *    <li>com.ninja-squad:springmockk</li>
         *    <li>org.jetbrains.kotlin:kotlin-test</li>
         *    <li>org.jetbrains.kotlin:kotlin-test-junit5</li>
         *    <li>org.junit.jupiter:junit-jupiter-api</li>
         *    <li>org.junit.jupiter:junit-jupiter-api</li>
         *    <li>org.hamcrest:hamcrest</li>
         *    <li>org.springframework.boot:spring-boot-starter-test</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getJunit() {
            return createBundle("test.junit");
        }

        /**
         * Dependency bundle provider for <b>test.kotest</b> which contains the following dependencies:
         * <ul>
         *    <li>io.mockk:mockk</li>
         *    <li>com.ninja-squad:springmockk</li>
         *    <li>io.kotest:kotest-runner-junit5</li>
         *    <li>io.kotest.extensions:kotest-extensions-spring</li>
         *    <li>org.springframework.boot:spring-boot-starter-test</li>
         *    <li>io.kotest.extensions:kotest-extensions-mockserver</li>
         *    <li>io.kotest.extensions:kotest-extensions-testcontainers</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getKotest() {
            return createBundle("test.kotest");
        }

    }

    public static class PluginAccessors extends PluginFactory {
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final SpringPluginAccessors paccForSpringPluginAccessors = new SpringPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.kotlin</b>
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.spring</b>
         */
        public SpringPluginAccessors getSpring() {
            return paccForSpringPluginAccessors;
        }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin.allopen</b> with plugin id <b>org.jetbrains.kotlin:kotlin-allopen</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAllopen() { return createPlugin("kotlin.allopen"); }

        /**
         * Plugin provider for <b>kotlin.kapt</b> with plugin id <b>org.jetbrains.kotlin.kapt</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKapt() { return createPlugin("kotlin.kapt"); }

        /**
         * Plugin provider for <b>kotlin.noarg</b> with plugin id <b>org.jetbrains.kotlin:kotlin-noarg</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getNoarg() { return createPlugin("kotlin.noarg"); }

    }

    public static class SpringPluginAccessors extends PluginFactory {
        private final SpringDependencyPluginAccessors paccForSpringDependencyPluginAccessors = new SpringDependencyPluginAccessors(providers, config);

        public SpringPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>spring.boot</b> with plugin id <b>org.springframework.boot</b> and
         * with version reference <b>spring.boot</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getBoot() { return createPlugin("spring.boot"); }

        /**
         * Group of plugins at <b>plugins.spring.dependency</b>
         */
        public SpringDependencyPluginAccessors getDependency() {
            return paccForSpringDependencyPluginAccessors;
        }

    }

    public static class SpringDependencyPluginAccessors extends PluginFactory {

        public SpringDependencyPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>spring.dependency.management</b> with plugin id <b>io.spring.dependency-management</b> and
         * with version reference <b>spring.dependency.management</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getManagement() { return createPlugin("spring.dependency.management"); }

    }

}
