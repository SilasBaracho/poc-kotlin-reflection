package sb.pma.core.domain.productCategory.model

import java.time.LocalDateTime

data class ProductCategoryImpl(
    override val id: Long? = null,
    override val name: String,
    override val createdAt: LocalDateTime = LocalDateTime.now(),
    override val updatedAt: LocalDateTime? = null
): ProductCategory, java.io.Serializable{}