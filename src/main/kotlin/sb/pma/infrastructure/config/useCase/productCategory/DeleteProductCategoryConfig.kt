package sb.pma.infrastructure.config.useCase.productCategory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.productCategory.useCase.DeleteProductCategoryUseCase
import sb.pma.core.useCase.productCategory.delete.DeleteProductCategoryUseCaseImpl
import sb.pma.infrastructure.resources.productCategory.gateway.DeleteProductCategoryGatewayImpl
import sb.pma.infrastructure.resources.productCategory.gateway.FindByIdProductCategoryGatewayImpl

@Configuration
class DeleteProductCategoryConfig {

    @Bean
    fun deleteProductCategoryUseCase(
        deleteProductCategoryGateway: DeleteProductCategoryGatewayImpl,
        findByIdProductCategoryGateway: FindByIdProductCategoryGatewayImpl
    ): DeleteProductCategoryUseCase {
        return DeleteProductCategoryUseCaseImpl(
            deleteProductCategoryGateway,
            findByIdProductCategoryGateway
        )
    }
}