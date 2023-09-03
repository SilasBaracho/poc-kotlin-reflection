package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory
import java.util.Optional

interface FindByIdProductCategoryGateway {

    fun execute(id: Long): Optional<ProductCategory>
}