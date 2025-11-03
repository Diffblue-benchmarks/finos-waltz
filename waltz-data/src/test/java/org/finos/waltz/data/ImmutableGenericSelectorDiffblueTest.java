package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.data.ImmutableGenericSelector.Builder;
import org.finos.waltz.model.EntityKind;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGenericSelectorDiffblueTest {
  /**
   * Test Builder {@link Builder#from(GenericSelector)}.
   * <p>
   * Method under test: {@link Builder#from(GenericSelector)}
   */
  @Test
  @DisplayName("Test Builder from(GenericSelector)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericSelector)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.selector()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).selector();
  }

  /**
   * Test Builder {@link Builder#from(GenericSelector)}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then builder build kind is {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GenericSelector)}
   */
  @Test
  @DisplayName("Test Builder from(GenericSelector); given 'ALL'; then builder build kind is 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericSelector)"})
  void testBuilderFrom_givenAll_thenBuilderBuildKindIsAll() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.selector()).thenReturn(mock(Select.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    verify(instance).selector();
    assertEquals(EntityKind.ALL, builderResult.build().kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(GenericSelector)}.
   * <ul>
   *   <li>When {@link GenericSelector} {@link GenericSelector#kind()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GenericSelector)}
   */
  @Test
  @DisplayName("Test Builder from(GenericSelector); when GenericSelector kind() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericSelector)"})
  void testBuilderFrom_whenGenericSelectorKindThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));
    when(instance.selector()).thenReturn(mock(Select.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
    verify(instance).selector();
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#selector(Select)}.
   * <p>
   * Method under test: {@link Builder#selector(Select)}
   */
  @Test
  @DisplayName("Test Builder selector(Select)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.selector(Select)"})
  void testBuilderSelector() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selector(mock(Select.class)));
  }
}
