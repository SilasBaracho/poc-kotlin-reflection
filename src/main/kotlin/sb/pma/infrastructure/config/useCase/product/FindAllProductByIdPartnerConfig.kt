package sb.pma.infrastructure.config.useCase.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sb.pma.core.domain.product.useCase.FindAllProductByIdPartnerUseCase
import sb.pma.core.useCase.product.findAll.FindAllProductByIdPartnerUseCaseImpl
import sb.pma.infrastructure.resources.product.gateway.FindAllProductByIdPartnerGatewayImpl

@Configuration
class FindAllProductByIdPartnerConfig {

    @Bean
    fun findAllProductByIdPartnerUseCase(
        findAllProductByIdPartnerGateway: FindAllProductByIdPartnerGatewayImpl,
    ): FindAllProductByIdPartnerUseCase {
        return FindAllProductByIdPartnerUseCaseImpl(
            findAllProductByIdPartnerGateway,
        )
    }
}