package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class LicenceGeneratorDiffblueTest {
  /**
   * Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  void testCreate() {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    // Act and Assert
    assertNull(licenceGenerator.create(new AnnotationConfigApplicationContext()));
  }

  /**
   * Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  void testCreate2() {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.addApplicationListener(mock(ApplicationListener.class));

    // Act and Assert
    assertNull(licenceGenerator.create(ctx));
  }

  /**
   * Method under test: {@link LicenceGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = licenceGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"licence\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
