package sb.pma.core.useCase.productCategory.delete

import sb.pma.core.domain.productCategory.gateway.DeleteProductCategoryGateway
import sb.pma.core.domain.productCategory.gateway.FindByIdProductCategoryGateway
import sb.pma.core.domain.productCategory.useCase.DeleteProductCategoryUseCase
import sb.pma.infrastructure.exception.NotFoundException

class DeleteProductCategoryUseCaseImpl(
    private val deleteProductCategoryGateway: DeleteProductCategoryGateway,
    private val findByIdProductCategoryGateway: FindByIdProductCategoryGateway
): DeleteProductCategoryUseCase {

    override operator fun invoke(payload: DeleteProductCategoryInput){
        val product = findByIdProductCategoryGateway.execute(payload.id).orElseThrow { NotFoundException("Category Not Found") }
        deleteProductCategoryGateway.execute(product)
    }
}