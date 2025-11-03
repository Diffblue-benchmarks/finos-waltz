package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo.Builder;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUsageInfoDiffblueTest {
  /**
   * Test {@link ImmutableUsageInfo#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUsageInfo#builder()}
   *   <li>{@link ImmutableUsageInfo#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUsageInfo Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableUsageInfo.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#from(UsageInfo)}.
   * <p>
   * Method under test: {@link Builder#from(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UsageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UsageInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).isSelected();
    verify(instance).kind();
    ImmutableUsageInfo buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(UsageKind.CONSUMER, buildResult.kind());
    assertTrue(buildResult.isSelected());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UsageInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UsageInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UsageInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).isSelected();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#isSelected(boolean)}.
   * <p>
   * Method under test: {@link Builder#isSelected(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSelected(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isSelected(boolean)"})
  void testBuilderIsSelected() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSelected(true));
  }

  /**
   * Test Builder {@link Builder#kind(UsageKind)}.
   * <p>
   * Method under test: {@link Builder#kind(UsageKind)}
   */
  @Test
  @DisplayName("Test Builder kind(UsageKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(UsageKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(UsageKind.CONSUMER));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setKind(UsageKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setKind(UsageKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(UsageKind.CONSUMER);

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(UsageKind.CONSUMER, actualJson.kind);
    assertFalse(actualJson.isSelected);
    assertFalse(actualJson.isSelectedIsSet);
  }

  /**
   * Test Json {@link Json#isSelected()}.
   * <p>
   * Method under test: {@link Json#isSelected()}
   */
  @Test
  @DisplayName("Test Json isSelected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isSelected()"})
  void testJsonIsSelected() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isSelected());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UsageKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#setIsSelected(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsSelected(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSelected(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsSelected(boolean)"})
  void testJsonSetIsSelected() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSelected(true);

    // Assert
    assertTrue(json.isSelected);
    assertTrue(json.isSelectedIsSet);
  }
}
