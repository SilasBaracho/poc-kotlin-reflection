package sb.pma.core.domain.productCategory.model

import java.time.LocalDateTime

interface ProductCategory {
    val id: Long?
    val name: String
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime?
}