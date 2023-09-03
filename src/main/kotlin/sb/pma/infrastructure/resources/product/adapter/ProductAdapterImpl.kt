package sb.pma.infrastructure.resources.product.adapter

import org.springframework.stereotype.Component
import sb.pma.core.domain.product.model.Product
import sb.pma.core.domain.product.model.ProductImpl
import sb.pma.infrastructure.config.db.schema.ProductSchema
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter

@Component
class ProductAdapterImpl(
    private val productCategoryAdapter: ProductCategoryAdapter
): ProductAdapter {

    override fun toSchema(product: Product): ProductSchema {
        return ProductSchema(
            idPartner = product.idPartner,
            idProduct = product.idProduct,
            name = product.name,
            description = product.description,
            price = product.price,
            active = product.active,
            extraIngredientLimit = product.extraIngredientLimit,
            createAt = product.createAt,
            updateAt = product.updateAt,
            productCategory = productCategoryAdapter.toSchema(product.productCategory)
        )
    }

    override fun toDomain(productSchema: ProductSchema): Product {
        return ProductImpl(
            idPartner = productSchema.idPartner,
            idProduct = productSchema.idProduct,
            name = productSchema.name,
            description = productSchema.description,
            price = productSchema.price,
            active = productSchema.active,
            extraIngredientLimit = productSchema.extraIngredientLimit,
            createAt = productSchema.createAt,
            updateAt = productSchema.updateAt,
            productCategory = productCategoryAdapter.toDomain(productSchema.productCategory)
        )
    }
}