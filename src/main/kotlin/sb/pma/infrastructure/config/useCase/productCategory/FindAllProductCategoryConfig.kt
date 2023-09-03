package sb.pma.infrastructure.config.useCase.productCategory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.productCategory.useCase.FindAllProductCategoryUseCase
import sb.pma.core.useCase.productCategory.findAll.FindAllProductCategoryUseCaseImpl
import sb.pma.infrastructure.resources.productCategory.gateway.FindAllProductCategoryGatewayImpl

@Configuration
class FindAllProductCategoryConfig {

    @Bean
    fun findAllProductCategoryUseCase(
        findAllProductCategoryGateway: FindAllProductCategoryGatewayImpl
    ): FindAllProductCategoryUseCase {
        return FindAllProductCategoryUseCaseImpl(
            findAllProductCategoryGateway
        )
    }
}