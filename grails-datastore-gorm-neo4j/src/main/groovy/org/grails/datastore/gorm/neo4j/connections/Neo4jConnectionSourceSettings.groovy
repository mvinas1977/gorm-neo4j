package org.grails.datastore.gorm.neo4j.connections

import groovy.transform.AutoClone
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import org.grails.datastore.gorm.neo4j.config.Neo4jDriverConfigBuilder
import org.grails.datastore.gorm.neo4j.config.Settings
import org.grails.datastore.mapping.core.connections.ConnectionSourceSettings

/**
 * Settings for Neo4j
 *
 * @author Graeme Rocher
 * @since 6.0
 */
@AutoClone
@Builder(builderStrategy = SimpleStrategy, prefix = '')
class Neo4jConnectionSourceSettings extends ConnectionSourceSettings implements Settings {

    /**
     * The URL to connect to
     */
    String url = DEFAULT_URL

    /**
     * The username to use
     */
    String username

    /**
     * The password to use
     */
    String password

    /**
     * The Neo4j connection type
     */
    ConnectionType type = ConnectionType.remote

    /**
     * Whether to build the Neo4j index
     */
    boolean buildIndex = true

    /**
     * The data location when using embedded
     */
    String location = DEFAULT_LOCATION

    /**
     * Neo4j driver options
     */
    Neo4jDriverConfigBuilder options

    /**
     * Neo4j embedded mode options
     */
    EmbeddedSettings embedded = new EmbeddedSettings()

    @AutoClone
    @Builder(builderStrategy = SimpleStrategy, prefix = '')
    static class EmbeddedSettings {
        Map options = [:]
    }

    static enum ConnectionType {
        remote, embedded
    }
}
