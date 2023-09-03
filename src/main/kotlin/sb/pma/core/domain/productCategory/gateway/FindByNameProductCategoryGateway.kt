package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory
import java.util.Optional

interface FindByNameProductCategoryGateway {

    fun execute(name: String): Optional<ProductCategory>
}