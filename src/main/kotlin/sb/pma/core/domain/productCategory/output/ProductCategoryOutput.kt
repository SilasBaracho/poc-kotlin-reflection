package sb.pma.core.domain.productCategory.output

import java.time.LocalDateTime

interface ProductCategoryOutput{
    val id: Long
    val name: String
    val createdAt: LocalDateTime?
    val updatedAt: LocalDateTime?
}
