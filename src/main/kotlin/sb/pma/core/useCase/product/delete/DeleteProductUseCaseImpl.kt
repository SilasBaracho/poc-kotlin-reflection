package sb.pma.core.useCase.product.delete

import sb.pma.core.domain.product.gateway.DeleteProductGateway
import sb.pma.core.domain.product.gateway.FindProductByIdAndIdPartnerGateway
import sb.pma.core.domain.product.useCase.DeleteProductUseCase
import sb.pma.infrastructure.exception.IllegalBusinessException

class DeleteProductUseCaseImpl(
    private val deleteProductGateway: DeleteProductGateway,
    private val findProductByIdAndIdPartnerGateway: FindProductByIdAndIdPartnerGateway
): DeleteProductUseCase {

    override operator fun invoke(payload: DeleteProductInput){
        val product = findProductByIdAndIdPartnerGateway
            .execute(payload.idProduct, payload.idPartner)
            .orElseThrow { IllegalBusinessException("Product not found or does not belong to the partner") }

        deleteProductGateway.execute(product)
    }
}