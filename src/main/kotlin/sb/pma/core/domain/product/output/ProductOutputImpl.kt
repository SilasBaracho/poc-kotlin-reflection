package sb.pma.core.domain.product.output


import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.product.model.Product
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ProductOutputImpl(
    override val idProduct: UUID,
    override val idPartner: UUID,
    override val name: String,
    override val description: String? = null,
    override val price: BigDecimal,
    override val active: Boolean?,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime? = null,
    override var productCategory: ProductCategoryOutput
): ProductOutput, java.io.Serializable {

    constructor(product: Product) : this(
        idPartner = product.idPartner,
        idProduct = product.idProduct,
        name = product.name,
        description = product.description,
        price = product.price,
        active = product.active,
        createdAt = product.createAt,
        updatedAt = product.updateAt,
        productCategory = ProductCategoryOutputImpl(
            product.productCategory.id!!,
            product.productCategory.name,
            product.productCategory.createdAt,
            product.productCategory.updatedAt,
        )
    )

}