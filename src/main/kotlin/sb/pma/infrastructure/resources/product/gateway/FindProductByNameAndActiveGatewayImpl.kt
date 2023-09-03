package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.gateway.FindProductByNameAndActiveGateway
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter
import java.util.Optional

@Component
class FindProductByNameAndActiveGatewayImpl(
    private val productAdapter: ProductAdapter,
    private val productRepository: ProductRepository
): FindProductByNameAndActiveGateway {

    override fun execute(name: String): Optional<Product> {
        val product = productRepository.findByNameAndActiveTrue(name).orElse(null)
        return if (product != null) {
            Optional.of(
                productAdapter.toDomain(product)
            )
        } else {
            Optional.empty()
        }
    }

}