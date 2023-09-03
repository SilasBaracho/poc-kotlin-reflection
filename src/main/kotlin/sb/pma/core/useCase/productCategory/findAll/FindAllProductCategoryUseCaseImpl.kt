package sb.pma.core.useCase.productCategory.findAll

import sb.pma.core.domain.productCategory.gateway.FindAllProductCategoryGateway
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindAllProductCategoryUseCase

class FindAllProductCategoryUseCaseImpl(
    private val findAllProductCategoryGateway: FindAllProductCategoryGateway
): FindAllProductCategoryUseCase {

    override operator fun invoke(): List<ProductCategoryOutput> {
        return findAllProductCategoryGateway.execute().map { ProductCategoryOutputImpl(it) }
    }
}