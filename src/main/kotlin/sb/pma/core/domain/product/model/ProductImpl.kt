package sb.pma.core.domain.product.model

import sb.pma.core.domain.productCategory.model.ProductCategory
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ProductImpl(
    override val idProduct: UUID = UUID.randomUUID(),
    override val idPartner: UUID,
    override val name: String,
    override val description: String?,
    override val price: BigDecimal,
    override val active: Boolean? = true,
    override val extraIngredientLimit: Int?,
    override val createAt: LocalDateTime = LocalDateTime.now(),
    override val updateAt: LocalDateTime? = null,
    override var productCategory: ProductCategory,
): Product, java.io.Serializable {}