package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.bulk_upload.ImmutableTabularRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTabularRowDiffblueTest {
  /**
   * Test Builder {@link Builder#from(TabularRow)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then builder build rowNumber is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TabularRow)}
   */
  @Test
  @DisplayName("Test Builder from(TabularRow); given ten; then builder build rowNumber is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TabularRow)"})
  void testBuilderFrom_givenTen_thenBuilderBuildRowNumberIsTen() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();
    TabularRow instance = mock(TabularRow.class);
    when(instance.rowNumber()).thenReturn(10);
    when(instance.values()).thenReturn(new String[]{"42"});

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).rowNumber();
    verify(instance).values();
    assertEquals(10, builderResult.build().rowNumber());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TabularRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TabularRow)}
   */
  @Test
  @DisplayName("Test Builder from(TabularRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TabularRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();
    TabularRow instance = mock(TabularRow.class);
    when(instance.rowNumber()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).rowNumber();
  }

  /**
   * Test Builder {@link Builder#rowNumber(int)}.
   * <p>
   * Method under test: {@link Builder#rowNumber(int)}
   */
  @Test
  @DisplayName("Test Builder rowNumber(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowNumber(int)"})
  void testBuilderRowNumber() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowNumber(10));
  }

  /**
   * Test Builder {@link Builder#values(String[])}.
   * <p>
   * Method under test: {@link Builder#values(String[])}
   */
  @Test
  @DisplayName("Test Builder values(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.values(String[])"})
  void testBuilderValues() {
    // Arrange
    Builder builderResult = ImmutableTabularRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values("42"));
  }
}
