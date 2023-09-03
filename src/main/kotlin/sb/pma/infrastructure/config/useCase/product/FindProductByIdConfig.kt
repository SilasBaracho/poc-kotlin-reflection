package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.FindProductByIdUseCase
import sb.pma.core.useCase.product.findById.FindProductByIdUseCaseImpl
import sb.pma.infrastructure.resources.product.gateway.FindProductByIdGatewayImpl

@Configuration
class FindProductByIdConfig {

    @Bean
    fun findProductByIdUseCase(
        findProductByIdGateway: FindProductByIdGatewayImpl
    ): FindProductByIdUseCase {
        return FindProductByIdUseCaseImpl(
            findProductByIdGateway
        )
    }
}