package sb.pma.core.domain.productCategory.output

import sb.pma.core.domain.productCategory.model.ProductCategory
import java.time.LocalDateTime

data class ProductCategoryOutputImpl(
    override val id: Long,
    override val name: String,
    override val createdAt: LocalDateTime?,
    override val updatedAt: LocalDateTime? = null
): ProductCategoryOutput, java.io.Serializable{

    constructor(productCategory: ProductCategory) : this(
        id = productCategory.id!!,
        name = productCategory.name,
        createdAt = productCategory.createdAt,
        updatedAt = productCategory.updatedAt
    )


}
