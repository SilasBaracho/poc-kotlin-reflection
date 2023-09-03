package sb.pma

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductManagerApiApplication

fun main(args: Array<String>) {
	runApplication<ProductManagerApiApplication>(*args)
}
