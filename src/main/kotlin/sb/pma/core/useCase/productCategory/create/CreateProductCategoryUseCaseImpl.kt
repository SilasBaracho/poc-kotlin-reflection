package sb.pma.core.useCase.productCategory.create

import sb.pma.core.domain.productCategory.gateway.SaveProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategoryImpl
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.CreateProductCategoryUseCase
import java.time.LocalDateTime

class CreateProductCategoryUseCaseImpl(
    private val saveProductCategoryGateway: SaveProductCategoryGateway
): CreateProductCategoryUseCase {

    override operator fun invoke(payload: CreateProductCategoryInput): ProductCategoryOutput {
        return ProductCategoryOutputImpl(
            saveProductCategoryGateway.execute(
                ProductCategoryImpl(
                    name = payload.name,
                    createdAt = LocalDateTime.now()
                )
            )
        )
    }
}