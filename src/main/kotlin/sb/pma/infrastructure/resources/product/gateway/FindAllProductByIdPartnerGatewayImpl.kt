package sb.pma.infrastructure.resources.product.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.gateway.FindAllProductByIdPartnerGateway
import sb.pma.core.domain.product.model.Product
import sb.pma.infrastructure.config.db.repository.ProductRepository
import sb.pma.infrastructure.resources.product.adapter.ProductAdapter
import java.util.UUID

@Component
class FindAllProductByIdPartnerGatewayImpl(
    private val productAdapter: ProductAdapter,
    private val productRepository: ProductRepository
): FindAllProductByIdPartnerGateway {

    override fun execute(idPartner: UUID): MutableList<Product> {
        val products = productRepository.findAllByIdPartner(idPartner)
        return products.map { product -> productAdapter.toDomain(product) }.toMutableList()
    }

}