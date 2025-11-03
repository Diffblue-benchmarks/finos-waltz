package org.finos.waltz.model.custom_environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.CustomEnvironmentAsset;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsageInfo.Builder;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsageInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentUsageInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#asset(CustomEnvironmentAsset)}.
   * <p>
   * Method under test: {@link Builder#asset(CustomEnvironmentAsset)}
   */
  @Test
  @DisplayName("Test Builder asset(CustomEnvironmentAsset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.asset(CustomEnvironmentAsset)"})
  void testBuilderAsset() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.asset(mock(CustomEnvironmentAsset.class)));
  }

  /**
   * Test Builder {@link Builder#from(CustomEnvironmentUsageInfo)}.
   * <p>
   * Method under test: {@link Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironmentUsageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironmentUsageInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.owningApplication()).thenThrow(new IllegalStateException("instance"));
    when(instance.usage()).thenReturn(new ImmutableCustomEnvironmentUsage.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).owningApplication();
    verify(instance).usage();
  }

  /**
   * Test Builder {@link Builder#from(CustomEnvironmentUsageInfo)}.
   * <p>
   * Method under test: {@link Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironmentUsageInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironmentUsageInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.asset()).thenThrow(new IllegalStateException("instance"));
    when(instance.owningApplication()).thenReturn(mock(Application.class));
    when(instance.usage()).thenReturn(new ImmutableCustomEnvironmentUsage.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).asset();
    verify(instance).owningApplication();
    verify(instance).usage();
  }

  /**
   * Test Builder {@link Builder#from(CustomEnvironmentUsageInfo)}.
   * <ul>
   *   <li>Given {@link CustomEnvironmentAsset}.</li>
   *   <li>Then builder build usage is {@link ImmutableCustomEnvironmentUsage.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironmentUsageInfo); given CustomEnvironmentAsset; then builder build usage is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironmentUsageInfo)"})
  void testBuilderFrom_givenCustomEnvironmentAsset_thenBuilderBuildUsageIsJson() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.asset()).thenReturn(mock(CustomEnvironmentAsset.class));
    when(instance.owningApplication()).thenReturn(mock(Application.class));
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    when(instance.usage()).thenReturn(json);

    // Act
    Builder<CustomEnvironmentAsset> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).asset();
    verify(instance).owningApplication();
    verify(instance).usage();
    assertSame(json, builderResult.build().usage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#owningApplication(Application)}.
   * <ul>
   *   <li>When {@link Application}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#owningApplication(Application)}
   */
  @Test
  @DisplayName("Test Builder owningApplication(Application); when Application; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.owningApplication(Application)"})
  void testBuilderOwningApplication_whenApplication_thenReturnBuilder() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owningApplication(mock(Application.class)));
  }

  /**
   * Test Builder {@link Builder#usage(CustomEnvironmentUsage)}.
   * <ul>
   *   <li>When {@link ImmutableCustomEnvironmentUsage.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#usage(CustomEnvironmentUsage)}
   */
  @Test
  @DisplayName("Test Builder usage(CustomEnvironmentUsage); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.usage(CustomEnvironmentUsage)"})
  void testBuilderUsage_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usage(new ImmutableCustomEnvironmentUsage.Json()));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAsset(CustomEnvironmentAsset)}
   *   <li>{@link Json#setOwningApplication(Application)}
   *   <li>{@link Json#setUsage(CustomEnvironmentUsage)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAsset(CustomEnvironmentAsset)",
      "void Json.setOwningApplication(Application)", "void Json.setUsage(CustomEnvironmentUsage)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<CustomEnvironmentAsset> actualJson = new Json<>();
    actualJson.setAsset(mock(CustomEnvironmentAsset.class));
    actualJson.setOwningApplication(null);
    actualJson.setUsage(new ImmutableCustomEnvironmentUsage.Json());

    // Assert
    assertFalse(((ImmutableCustomEnvironmentUsage.Json) actualJson.usage).id.isPresent());
  }

  /**
   * Test Json {@link Json#owningApplication()}.
   * <p>
   * Method under test: {@link Json#owningApplication()}
   */
  @Test
  @DisplayName("Test Json owningApplication()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Application Json.owningApplication()"})
  void testJsonOwningApplication() {
    // Arrange
    Json<CustomEnvironmentAsset> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.owningApplication());
  }

  /**
   * Test Json {@link Json#usage()}.
   * <p>
   * Method under test: {@link Json#usage()}
   */
  @Test
  @DisplayName("Test Json usage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomEnvironmentUsage Json.usage()"})
  void testJsonUsage() {
    // Arrange
    Json<CustomEnvironmentAsset> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.usage());
  }
}
