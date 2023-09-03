package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.gateway.DeleteProductGateway
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository

@Component
class DeleteProductGatewayImpl(
    private val productRepository: ProductRepository
): DeleteProductGateway {

    override fun execute(product: Product) {
        val productSchema = productRepository.findByIdProductAndIdPartner(product.idProduct, product.idPartner)
            .orElseThrow { NoSuchElementException("Product not found with id ${product.idProduct}") }

        return productRepository.delete(productSchema)
    }

}