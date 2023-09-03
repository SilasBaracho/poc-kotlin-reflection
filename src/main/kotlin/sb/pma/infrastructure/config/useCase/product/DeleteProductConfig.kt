package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.DeleteProductUseCase
import sb.pma.core.useCase.product.delete.DeleteProductUseCaseImpl
import sb.pma.infrastructure.resources.product.gateway.DeleteProductGatewayImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByIdAndIdPartnerGatewayImpl

@Configuration
class DeleteProductConfig {

    @Bean
    fun deleteProductUseCase(
        deleteProductGateway: DeleteProductGatewayImpl,
        findProductByIdAndIdPartnerGateway: FindProductByIdAndIdPartnerGatewayImpl
    ): DeleteProductUseCase {
        return DeleteProductUseCaseImpl(
            deleteProductGateway,
            findProductByIdAndIdPartnerGateway
        )
    }
}