package sb.pma.infrastructure.resources.productCategory.adapter

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.core.domain.productCategory.model.ProductCategoryImpl
import sb.pma.infrastructure.config.db.schema.ProductCategorySchema

@Component
class ProductCategoryAdapterImpl: ProductCategoryAdapter {
    override fun toSchema(productCategory: ProductCategory): ProductCategorySchema {
        return ProductCategorySchema(
            productCategory.id,
            productCategory.name,
            productCategory.createdAt,
            productCategory.updatedAt
        )
    }

    override fun toDomain(productCategorySchema: ProductCategorySchema): ProductCategory {
        return ProductCategoryImpl(
            productCategorySchema.id,
            productCategorySchema.name,
            productCategorySchema.createdAt,
            productCategorySchema.updatedAt
        )
    }
}