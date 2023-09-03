package sb.pma.infrastructure.config.db.schema

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "product")
data class ProductSchema(
    @Id
    @Column(name = "id_product")
    val idProduct: UUID = UUID.randomUUID(),

    @Column(name = "id_partner")
    val idPartner: UUID,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "price")
    val price: BigDecimal,

    @Column(name = "flg_active")
    val active: Boolean? = true,

    @Column(name = "extra_ingredient_limit")
    val extraIngredientLimit: Int? = 0,

    @Column(name = "create_at")
    val createAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "update_at")
    val updateAt: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "idt_product_category")
    var productCategory: ProductCategorySchema,
): java.io.Serializable {}