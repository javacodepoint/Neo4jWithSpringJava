package main.java.example.movies.backend;

import main.java.example.movies.util.Util;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.setPort;

/**
 * @author Michael Hunger @since 22.10.13
 */
public class MovieServer {

	//start from here
    public static void main(String[] args) {
        setPort(Util.getWebPort());
        externalStaticFileLocation("src/main/webapp");
        final MovieService service = new MovieService(Util.getNeo4jUrl());
        new MovieRoutes(service).init();
     // JSON object for single movie with cast
       // +curl http://localhost:8080/movie/The%20Matrix
     // list of JSON objects for movie search results
     //  +curl http://localhost:8080/search?q=matrix
       // JSON object for whole graph viz (nodes, links - arrays)
       //+curl http://localhost:8080/graph
        //https://github.com/neo4j-examples/neo4j-movies-java-bolt/commit/4f16769764fce32c41f77584bd6b16c533a8e994
        //https://neo4j.com/developer/guide-sql-to-cypher/
        //https://github.com/neo4j-examples/neo4j-movies-java-bolt
        //https://neo4j.com/community/
        //http://neo4j.com/docs/developer-manual/current/get-started/cypher/getting-the-results-you-want/
    }
}
