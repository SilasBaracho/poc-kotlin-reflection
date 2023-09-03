package sb.pma.core.domain.product.model

import sb.pma.core.domain.productCategory.model.ProductCategory
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

interface Product {
    val idProduct: UUID
    val idPartner: UUID
    val name: String
    val description: String?
    val price: BigDecimal
    val active: Boolean?
    val extraIngredientLimit: Int?
    val createAt: LocalDateTime
    val updateAt: LocalDateTime?
    var productCategory: ProductCategory
}