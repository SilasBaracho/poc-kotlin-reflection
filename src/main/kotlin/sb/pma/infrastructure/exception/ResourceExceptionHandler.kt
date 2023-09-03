package sb.pma.infrastructure.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import sb.pma.infrastructure.exception.model.StandardError

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(
        e: NotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<StandardError<String>> {
        val exception = StandardError(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            path = request.servletPath,
            message = e.message!!,
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception)
    }

    @ExceptionHandler(IllegalBusinessException::class)
    fun notFoundException(
        e: IllegalBusinessException,
        request: HttpServletRequest
    ): ResponseEntity<StandardError<String>> {
        val exception = StandardError(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            path = request.servletPath,
            message = e.message!!,
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception)
    }

}