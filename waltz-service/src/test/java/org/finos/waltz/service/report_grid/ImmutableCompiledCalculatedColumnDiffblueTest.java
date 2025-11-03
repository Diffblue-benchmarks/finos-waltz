package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.Either;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.service.report_grid.ImmutableCompiledCalculatedColumn.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCompiledCalculatedColumnDiffblueTest {
  /**
   * Test {@link ImmutableCompiledCalculatedColumn#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCompiledCalculatedColumn#builder()}
   *   <li>{@link ImmutableCompiledCalculatedColumn#expression(Either)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCompiledCalculatedColumn Builder.build()", "Builder Builder.expression(Either)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCompiledCalculatedColumn.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.expression(null));
  }

  /**
   * Test Builder {@link Builder#column(ReportGridDerivedColumnDefinition)}.
   * <ul>
   *   <li>Then builder build expression is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#column(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder column(ReportGridDerivedColumnDefinition); then builder build expression is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.column(ReportGridDerivedColumnDefinition)"})
  void testBuilderColumn_thenBuilderBuildExpressionIsNull() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ReportGridDerivedColumnDefinition column = mock(ReportGridDerivedColumnDefinition.class);

    // Act
    Builder actualColumnResult = builderResult.column(column);

    // Assert
    ImmutableCompiledCalculatedColumn buildResult = builderResult.build();
    assertNull(buildResult.expression());
    assertSame(builderResult, actualColumnResult);
    assertSame(column, buildResult.column());
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   * <p>
   * Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.column()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).column();
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   * <p>
   * Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenThrow(new IllegalStateException("instance"));
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).column();
    verify(instance).expression();
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   * <ul>
   *   <li>Given {@link Either}.</li>
   *   <li>When {@link CompiledCalculatedColumn} {@link CompiledCalculatedColumn#expression()} return {@link Either}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn); given Either; when CompiledCalculatedColumn expression() return Either")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom_givenEither_whenCompiledCalculatedColumnExpressionReturnEither() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(mock(Either.class));
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   * <ul>
   *   <li>Then builder build expression is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn); then builder build expression is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom_thenBuilderBuildExpressionIsNull() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    CompiledCalculatedColumn instance = mock(CompiledCalculatedColumn.class);
    when(instance.expression()).thenReturn(null);
    when(instance.column()).thenReturn(mock(ReportGridDerivedColumnDefinition.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).expression();
    assertNull(builderResult.build().expression());
    assertSame(builderResult, actualFromResult);
  }
}
