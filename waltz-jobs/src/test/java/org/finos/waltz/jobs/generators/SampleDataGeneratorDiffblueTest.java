package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SampleDataGeneratorDiffblueTest {
  /**
   * Method under test: {@link SampleDataGenerator#getDsl(ApplicationContext)}
   */
  @Test
  void testGetDsl() throws BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(SQLDialect.SQL99);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    DSLContext actualDsl = appGenerator.getDsl(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualDsl instanceof DefaultDSLContext);
    assertSame(defaultDSLContext, actualDsl);
  }
}
