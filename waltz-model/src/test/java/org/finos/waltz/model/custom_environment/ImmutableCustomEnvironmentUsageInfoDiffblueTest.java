package org.finos.waltz.model.custom_environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.CustomEnvironmentAsset;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.Application;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentUsageInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#asset(CustomEnvironmentAsset)}
   */
  @Test
  void testBuilderAsset() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.asset(mock(CustomEnvironmentAsset.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.owningApplication()).thenThrow(new IllegalStateException("instance"));
    when(instance.usage()).thenReturn(new ImmutableCustomEnvironmentUsage.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).owningApplication();
    verify(instance).usage();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.asset()).thenReturn(mock(CustomEnvironmentAsset.class));
    when(instance.owningApplication()).thenReturn(mock(Application.class));
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    when(instance.usage()).thenReturn(json);

    // Act
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).asset();
    verify(instance).owningApplication();
    verify(instance).usage();
    assertSame(json, builderResult.build().usage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#from(CustomEnvironmentUsageInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();
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
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#owningApplication(Application)}
   */
  @Test
  void testBuilderOwningApplication() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owningApplication(mock(Application.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#usage(CustomEnvironmentUsage)}
   */
  @Test
  void testBuilderUsage() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usage(new ImmutableCustomEnvironmentUsage.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Builder#usage(CustomEnvironmentUsage)}
   */
  @Test
  void testBuilderUsage2() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Builder<CustomEnvironmentAsset> builderResult = ImmutableCustomEnvironmentUsageInfo
        .builder();

    ImmutableCustomEnvironmentUsage.Json usage = new ImmutableCustomEnvironmentUsage.Json();
    usage.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.usage(usage));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo#copyOf(CustomEnvironmentUsageInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CustomEnvironmentUsageInfo<CustomEnvironmentAsset> instance = mock(CustomEnvironmentUsageInfo.class);
    when(instance.asset()).thenReturn(mock(CustomEnvironmentAsset.class));
    when(instance.owningApplication()).thenReturn(mock(Application.class));
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    when(instance.usage()).thenReturn(json);

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualCopyOfResult = ImmutableCustomEnvironmentUsageInfo
        .copyOf(instance);

    // Assert
    verify(instance).asset();
    verify(instance).owningApplication();
    verify(instance).usage();
    assertSame(json, actualCopyOfResult.usage());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo#fromJson(ImmutableCustomEnvironmentUsageInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Json<CustomEnvironmentAsset> json = new ImmutableCustomEnvironmentUsageInfo.Json<>();
    json.setAsset(mock(CustomEnvironmentAsset.class));
    ImmutableCustomEnvironmentUsage.Json usage = new ImmutableCustomEnvironmentUsage.Json();
    json.setUsage(usage);
    json.setOwningApplication(mock(Application.class));

    // Act
    ImmutableCustomEnvironmentUsageInfo<CustomEnvironmentAsset> actualFromJsonResult = ImmutableCustomEnvironmentUsageInfo
        .fromJson(json);

    // Assert
    assertSame(usage, actualFromJsonResult.usage());
    CustomEnvironmentAsset expectedAssetResult = json.asset;
    assertSame(expectedAssetResult, actualFromJsonResult.asset());
    Application expectedOwningApplicationResult = json.owningApplication;
    assertSame(expectedOwningApplicationResult, actualFromJsonResult.owningApplication());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableCustomEnvironmentUsageInfo.Json}
   *   <li>
   * {@link ImmutableCustomEnvironmentUsageInfo.Json#setAsset(CustomEnvironmentAsset)}
   *   <li>
   * {@link ImmutableCustomEnvironmentUsageInfo.Json#setOwningApplication(Application)}
   *   <li>
   * {@link ImmutableCustomEnvironmentUsageInfo.Json#setUsage(CustomEnvironmentUsage)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCustomEnvironmentUsageInfo.Json<CustomEnvironmentAsset> actualJson = new ImmutableCustomEnvironmentUsageInfo.Json<>();
    actualJson.setAsset(mock(CustomEnvironmentAsset.class));
    actualJson.setOwningApplication(null);
    actualJson.setUsage(new ImmutableCustomEnvironmentUsage.Json());

    // Assert
    assertFalse(((ImmutableCustomEnvironmentUsage.Json) actualJson.usage).id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsageInfo.Json#owningApplication()}
   */
  @Test
  void testJsonOwningApplication() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Json<CustomEnvironmentAsset> json = new ImmutableCustomEnvironmentUsageInfo.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.owningApplication());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsageInfo.Json#usage()}
   */
  @Test
  void testJsonUsage() {
    // Arrange
    ImmutableCustomEnvironmentUsageInfo.Json<CustomEnvironmentAsset> json = new ImmutableCustomEnvironmentUsageInfo.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.usage());
  }
}
