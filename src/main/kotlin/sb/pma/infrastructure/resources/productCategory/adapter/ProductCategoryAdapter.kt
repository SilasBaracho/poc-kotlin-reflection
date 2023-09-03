package sb.pma.infrastructure.resources.productCategory.adapter

import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.schema.ProductCategorySchema

interface ProductCategoryAdapter {

    fun toSchema(productCategory: ProductCategory): ProductCategorySchema

    fun toDomain(productCategorySchema: ProductCategorySchema): ProductCategory
}