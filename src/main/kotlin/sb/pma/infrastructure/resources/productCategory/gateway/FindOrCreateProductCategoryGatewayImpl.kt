package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.FindByNameProductCategoryGateway
import sb.pma.core.domain.productCategory.gateway.FindOrCreateProductCategoryGateway
import sb.pma.core.domain.productCategory.gateway.SaveProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.core.domain.productCategory.model.ProductCategoryImpl
import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameInput
import java.time.LocalDateTime

@Component
class FindOrCreateProductCategoryGatewayImpl(
    private val findByNameProductCategoryGateway: FindByNameProductCategoryGateway,
    private val saveProductCategoryGateway: SaveProductCategoryGateway
): FindOrCreateProductCategoryGateway {

    override fun execute(payload: FindProductCategoryByNameInput): ProductCategory {
        return findByNameProductCategoryGateway.execute(payload.name)
            .orElseGet {
                saveProductCategoryGateway.execute(
                    ProductCategoryImpl(name = payload.name, createdAt = LocalDateTime.now())
                )
            }
    }
}