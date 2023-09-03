package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.gateway.SaveProductGateway
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter

@Component
class SaveProductGatewayImpl(
    private val productAdapter: ProductAdapter,
    private val productRepository: ProductRepository
): SaveProductGateway {

    override fun execute(product: Product): Product {
        return productRepository.save(
            productAdapter.toSchema(product)
        ).let {
            productAdapter.toDomain(it)
        }
    }

}