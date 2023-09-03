package sb.pma.core.domain.product.output

import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

interface ProductOutput{
    val idProduct: UUID
    val idPartner: UUID
    val name: String
    val description: String?
    val price: BigDecimal
    val active: Boolean?
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime?
    var productCategory: ProductCategoryOutput
}