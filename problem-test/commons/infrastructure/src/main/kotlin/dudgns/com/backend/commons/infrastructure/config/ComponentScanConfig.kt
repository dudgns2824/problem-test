package dudgns.backend

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * kr.co.hmcnetworks.modules가 GroupId(패키지)인 스프링 빈들을 컴포넌트 스캔하기 위한 설정
 * 해당 설정 없이는 modules 아래 스프링 빈으로 등록한 클래스들을 컴포넌트 스캔하지 못함
 */
@Configuration
@ComponentScan(basePackages = arrayOf("dudgns.backend"))
class ComponentScanConfig