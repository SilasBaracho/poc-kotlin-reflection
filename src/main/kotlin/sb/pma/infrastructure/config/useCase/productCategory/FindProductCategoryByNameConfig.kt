package sb.pma.infrastructure.config.useCase.productCategory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByNameUseCase
import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameUseCaseImpl
import sb.pma.infrastructure.resources.productCategory.gateway.FindByNameProductCategoryGatewayImpl

@Configuration
class FindProductCategoryByNameConfig {

    @Bean
    fun findProductCategoryByNameUseCase(
        findByNameProductCategoryGateway: FindByNameProductCategoryGatewayImpl
    ): FindProductCategoryByNameUseCase {
        return FindProductCategoryByNameUseCaseImpl(
            findByNameProductCategoryGateway
        )
    }
}