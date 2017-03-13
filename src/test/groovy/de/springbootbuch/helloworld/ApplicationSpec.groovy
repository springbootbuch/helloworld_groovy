package de.springbootbuch.helloworld

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification
import spock.lang.Unroll
import sun.security.acl.WorldGroupImpl

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment

@SpringBootTest(
        webEnvironment = WebEnvironment.RANDOM_PORT,
        classes = [Application]
)
class ApplicationSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Unroll
    def 'test "Hello World" Controller with #param="#value"'()  {
        given: "a web client"
            def client = restTemplate
        when:  "/hello is requested with param #param='#value'"
            def response = client.getForEntity(
                                "/hello?${param}={value}",
                                Map,
                                [value:value]
                           )
        then:  "we get an http response #status"
            response?.statusCode == status
        and:   "greeting is '#greeting' "
            response?.body?.greeting == greeting
        where:
            param   | value        || status                 | greeting
            'name'  | 'World'      || HttpStatus.OK          | "Hello ${value}"
            'name'  | 'Universe'   || HttpStatus.OK          | "Hello ${value}"
            '-'     | 'max'        || HttpStatus.BAD_REQUEST | null
    }
}