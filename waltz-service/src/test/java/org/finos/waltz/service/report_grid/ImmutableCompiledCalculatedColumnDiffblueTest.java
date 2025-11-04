package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.commons.jexl3.JexlScript;
import org.finos.waltz.model.either.Either;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.junit.jupiter.api.Test;

class ImmutableCompiledCalculatedColumnDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCompiledCalculatedColumn#builder()}
   *   <li>{@link ImmutableCompiledCalculatedColumn#expression(Either)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCompiledCalculatedColumn.Builder actualBuilderResult = ImmutableCompiledCalculatedColumn.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.expression(null));
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn.Builder#column(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderColumn() {
    // Arrange
    ImmutableCompiledCalculatedColumn.Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ReportGridDerivedColumnDefinition column = mock(ReportGridDerivedColumnDefinition.class);

    // Act
    ImmutableCompiledCalculatedColumn.Builder actualColumnResult = builderResult.column(column);

    // Assert
    ImmutableCompiledCalculatedColumn buildResult = builderResult.build();
    assertNull(buildResult.expression());
    assertSame(builderResult, actualColumnResult);
    assertSame(column, buildResult.column());
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn.Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCompiledCalculatedColumn.Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.column()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).column();
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn.Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCompiledCalculatedColumn.Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(null);
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    ImmutableCompiledCalculatedColumn.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
    assertNull(actualFromResult.build().expression());
    assertNull(builderResult.build().expression());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn.Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCompiledCalculatedColumn.Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(mock(Either.class));
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    ImmutableCompiledCalculatedColumn.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn.Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCompiledCalculatedColumn.Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenThrow(new IllegalStateException("instance"));
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).column();
    verify(instance).expression();
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn#copyOf(CompiledCalculatedColumn)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(null);
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    ImmutableCompiledCalculatedColumn actualCopyOfResult = ImmutableCompiledCalculatedColumn.copyOf(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
    assertNull(actualCopyOfResult.expression());
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledCalculatedColumn#copyOf(CompiledCalculatedColumn)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(mock(Either.class));
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    ImmutableCompiledCalculatedColumn.copyOf(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
  }
}
