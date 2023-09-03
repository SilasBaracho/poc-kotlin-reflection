package sb.pma.infrastructure.config.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sb.pma.infrastructure.config.db.schema.ProductCategorySchema
import java.util.Optional

@Repository
interface ProductCategoryRepository: JpaRepository<ProductCategorySchema, Long> {

    fun findByName(name: String): Optional<ProductCategorySchema>

}