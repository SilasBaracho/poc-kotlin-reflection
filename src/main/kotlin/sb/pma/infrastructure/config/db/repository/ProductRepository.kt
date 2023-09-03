package sb.pma.infrastructure.config.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sb.pma.infrastructure.config.db.schema.ProductSchema
import java.util.Optional
import java.util.UUID

@Repository
interface ProductRepository: JpaRepository<ProductSchema, UUID> {
    fun findByIdProductAndIdPartner(idProduct: UUID, idPartner: UUID): Optional<ProductSchema>
    fun findAllByIdPartner(idPartner: UUID): MutableList<ProductSchema>
    fun findByNameAndActiveTrue(name: String): Optional<ProductSchema>
}